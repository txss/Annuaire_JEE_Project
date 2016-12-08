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
	
	@RequestMapping(value = "/person_List", method = RequestMethod.GET)
    public String showPersonsList(HttpServletRequest request) {
		HttpSession session = request.getSession();
//		if (session.getAttribute("user") == null)
//			return "redirect:login/sign_in";
		
	    session.setAttribute("personnes", personManager.getPersonList());

	    logger.info("Returning person_List view");
        return "lister_personnes";
    }
	
	
	
	
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
    public String showPersoninAnnuaire(
    		HttpServletRequest request,
    		final RedirectAttributes redirectAttributes,
    		@RequestParam(value = "id", required = false) Long personID) {
		
//		if (personID == null) {
//			redirectAttributes.addFlashAttribute("errorPers", "Oops cette personne n'as pas été trouvé dans l'annuaire.");
//	        logger.info("Person with id:" + personID + " not found.");
//	        return "show_person";
//	    }
		
		HttpSession session = request.getSession();
	    session.setAttribute("showPers", personManager.getPerson(personID));
		
	    logger.info("Returning show_person ("+personID+")  view.");
        return "show_person";
    }
	
	
	
	
	
	@RequestMapping(value = "/groups_List", method = RequestMethod.GET)
    public String showGroupsList(HttpServletRequest request) {
		HttpSession session = request.getSession();
//		if (session.getAttribute("user") == null)
//			return "redirect:login/sign_in";
		
		session.setAttribute("groupes", groupManager.getGroupList());
    	logger.info("Returning groups_List view");
        return "lister_groupes";
    }
	
	
	
	
	@RequestMapping(value = "/group", method = RequestMethod.GET)
    public String showGroupinAnnuaire(
    		HttpServletRequest request,
    		final RedirectAttributes redirectAttributes,
    		@RequestParam(value = "id", required = false) String groupID) {
		
		HttpSession session = request.getSession();
		session.setAttribute("group", groupManager.findGroup(groupID));
		session.setAttribute("showPersonInGroup", personManager.findAllPersonInGroup(groupID));
	    
	    logger.info("Returning show_group ("+groupID+")  view.");
        return "show_group";
    }
	
}
