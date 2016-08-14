/**
 * 
 */
package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author banhbaochay
 *
 */
@Controller
public class AngularJSController {
    @RequestMapping(value = "/angularJS", method = RequestMethod.GET)
    public String demo() {
        return "angularJS/index";
    }
}
