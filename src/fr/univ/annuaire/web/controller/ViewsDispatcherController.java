package fr.univ.annuaire.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.univ.annuaire.beans.Personne;
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
	
	public PersonManager getPersonManager() {
		return personManager;
	}
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	public GroupManager getGroupManager() {
		return groupManager;
	}
	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}


	/**
	 * retrun accueil view
	 * @return String, the name to the view
	 */
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String showAccueil() {
    	logger.info("Returning accueil view");
        return "accueil_view";
    }

	
	/**
	 * This methode solve the url with the search.
	 * If they find a possible match in database, return 
	 * @param request
	 * @param search
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchinAnnuaire(
    		HttpServletRequest request,
    		@RequestParam(value = "searcher", required = false) String search) {
		
		HttpSession session = request.getSession();
		
		long debut = System.currentTimeMillis();
		Collection<Personne> personnes = personManager.searchPerson(search);
		long time = System.currentTimeMillis()-debut;
		
		if(search != "" && personnes.size() != 0)
			session.setAttribute("personnes", personnes);
		else
			session.setAttribute("personnes", null);
		
		
		session.setAttribute("time",  time+" ms");
	    logger.info("Returning show_search_view ("+search+")  view.");
        return "searcher";
    }
	
}
