package fr.univ.annuaire.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.univ.annuaire.beans.Login;
import fr.univ.annuaire.dao.DaoException;
import fr.univ.annuaire.manager.LoginManager;

@Controller()
@RequestMapping("/login")
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	LoginManager manager;
    
	
	
    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String login(@ModelAttribute Login l, BindingResult result, HttpServletRequest request) {
    	HttpSession session = request.getSession();
	    session.setAttribute("user", null);
    	logger.info("Returning login view");
        return "login";
    }

    
    
    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public String loginRedirect(@ModelAttribute @Valid Login l, 
    							BindingResult result, 
    							final RedirectAttributes redirectAttributes, 
    							HttpServletRequest request) throws DaoException {
    	
    	if (result.hasErrors()) {
    		logger.info("Returning log view, auth failled: incorrect syntax");
            return "login";
        }
    	
    	if (manager.checkLogin(l)){
    		HttpSession session = request.getSession();
    	    session.setAttribute("user", true);
    		logger.info("Returning accueil view, auth success");
            return "redirect:/actions/accueil";
    	}
    	
    	redirectAttributes.addFlashAttribute("error", "Identifiant ou mot de passe incorect.");
    	logger.info("Returning log view, auth failled: wrong identifiants");
        return "redirect:sign_in";
    }
    
    
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(@ModelAttribute Login l, BindingResult result, HttpServletRequest request) {
    	HttpSession session = request.getSession();
	    session.setAttribute("user", null);
    	logger.info("Returning login view");
        return "redirect:sign_in";
    }
    
}