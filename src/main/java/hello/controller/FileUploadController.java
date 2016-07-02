package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hello.Application;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chopin on 6/6/16.
 */

@Controller
public class FileUploadController extends WebMvcConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);
    
    @RequestMapping(method = RequestMethod.GET, value = "/upload")
    public String provideUploadInfo(Model model) {
        LOGGER.info("Provide Upload Info");
        File rootFolder = new File(Application.ROOT);
        List<String> fileNames = Arrays.stream(rootFolder.listFiles()).map(f -> f.getName()).collect(Collectors.toList());
        model.addAttribute("files", fileNames);
        return "upload/uploadForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
        LOGGER.info("Starting upload file");
        if (name.contains("/")){
            redirectAttributes.addFlashAttribute("message", "Folder separators are not allowed");
            return "redirect:/upload";
        }
        try {
            if (!file.isEmpty()) {
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(Application.ROOT + "/" + name)));
                FileCopyUtils.copy(file.getInputStream(), outputStream);
                redirectAttributes.addFlashAttribute("message", "Upload file " + name + " successfully");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Upload file " + name + " failed. Caused by : " + e.getMessage());
            if (LOGGER.isDebugEnabled())
                LOGGER.debug("Upload file " + name + " failed", e);
        }
        
        return "redirect:/upload";
    }

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/uploadResult").setViewName("upload/result");
	}
}
