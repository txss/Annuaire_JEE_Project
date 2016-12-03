package fr.univ.annuaire.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller()
@RequestMapping("/login")
public class LoginController {

    protected final Log logger = LogFactory.getLog(getClass());

    
    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public ModelAndView sayHello() {
    	logger.info("Returning login view");
        return new ModelAndView("login");
    }

    
    
}