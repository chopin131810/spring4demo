package hello.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import hello.form.PersonForm;

@Controller
@RequestMapping(value = "/person")
public class PersonController extends WebMvcConfigurerAdapter {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(PersonForm personForm) {
		return "formValidation";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formValidation";
		}
		
		return "redirect:/person/success";
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/person/success").setViewName("success");
	}
}
