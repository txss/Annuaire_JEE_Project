package fr.univ.annuaire.web.controller;

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
    public String showAccueil() {
    	logger.info("Returning accueil view");
        return "accueil";
    }
	
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
    public String showProfil() {
    	logger.info("Returning accueil profil");
        return "profil";
    }
	
	@RequestMapping(value = "/person_List", method = RequestMethod.GET)
    public String showPersonsList() {
    	logger.info("Returning accueil profil");
        return "lister";
    }
	
	@RequestMapping(value = "/groups_List", method = RequestMethod.GET)
    public String showGroupsList() {
    	logger.info("Returning accueil profil");
        return "lister"; // TODO add param 
    }
	
	
}
