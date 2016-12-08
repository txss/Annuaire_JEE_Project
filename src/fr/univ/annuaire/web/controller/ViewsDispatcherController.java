package fr.univ.annuaire.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.univ.annuaire.manager.GroupManager;
import fr.univ.annuaire.manager.PersonManager;

@Controller()
@RequestMapping("")
public class ViewsDispatcherController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	PersonManager personManager;
	@Autowired
	GroupManager groupManager;
	
	
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String showAccueil(HttpServletRequest request) {
    	logger.info("Returning accueil view");
        return "accueil";
    }

	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchinAnnuaire(
    		final RedirectAttributes redirectAttributes,
    		HttpServletRequest request,
    		@RequestParam(value = "searcher", required = false) String search) {
		
		HttpSession session = request.getSession();
		long debut = System.currentTimeMillis();
		if(search != "")
			session.setAttribute("personnes", personManager.searchPerson(search));
		long time = System.currentTimeMillis()-debut;
		
		session.setAttribute("time",  time+" ms");
	    logger.info("Returning show_search_view ("+search+")  view.");
        return "searcher";
    }
	
}
