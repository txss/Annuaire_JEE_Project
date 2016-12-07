package fr.univ.annuaire.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping("")
public class ViewsDispatcherController {

protected final Log logger = LogFactory.getLog(getClass());


	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String showAccueil(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:login/sign_in";
		
    	logger.info("Returning accueil view");
        return "accueil";
    }
	
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
    public String showProfil(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:login/sign_in";
    	logger.info("Returning profil view");
        return "profil";
    }
	
	@RequestMapping(value = "/person_List", method = RequestMethod.GET)
    public String showPersonsList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:login/sign_in";
    	logger.info("Returning person_List view");
        return "lister";
    }
	
	@RequestMapping(value = "/groups_List", method = RequestMethod.GET)
    public String showGroupsList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:login/sign_in";
    	logger.info("Returning groups_List view");
        return "lister"; // TODO add param 
    }
	
	
}
