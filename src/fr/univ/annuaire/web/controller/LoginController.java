package fr.univ.annuaire.web.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.univ.annuaire.beans.Login;

@Controller()
@RequestMapping("/login")
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());
    
    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String login(@ModelAttribute Login l, BindingResult result) {
    	logger.info("Returning login view");
        return "login";
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public String loginRedirect(@ModelAttribute @Valid Login l, BindingResult result) {
    	
    	if (result.hasErrors()) {
    		logger.info("Returning log view, auth failled");
            return "login";
        }
//        manager.save(p);
    	logger.info("Returning accueil view, auth success");
        return "redirect:/actions/accueil";
    }
    
}