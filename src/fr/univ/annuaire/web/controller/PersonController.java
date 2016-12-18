/**
 * PersonController is the controller to routes all person request in the url
 * Every action in the application, or in Url, about the person need to be done in this controller
 * Show person, show all person in database..
 * @author Campanella & Magron
 */
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

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.manager.GroupManager;
import fr.univ.annuaire.manager.PersonManager;

@Controller()
@RequestMapping("person")
public class PersonController {

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
	 * This methode redirect to the view to see all person in the annuaire database
	 * The request id made by the personManager.
	 * @param request the result (a collection of person) is set in the attribute personnes in the user session
	 * @return the lister view
	 */
	@RequestMapping(value = "/person_List", method = RequestMethod.GET)
    public String showPersonsList(HttpServletRequest request) {
		HttpSession session = request.getSession();
	    session.setAttribute("personnes", personManager.getAllPerson());
	    logger.info("Returning person_List view");
        return "lister";
    }
	
	
	/**
	 * showPersonInAnnuaire show a person in the annuaire.
	 * It return the show_person view. The request is made by the personManager and the 
	 * result are set in the session attribute of the user in a Personne bean.
	 * @param request set the Personne bean result of the request in the user session
	 * @param personID the id of the person to visualize
	 * @return the view show_person with a Personnes bean
	 */
	@RequestMapping(value = "/show_person", method = RequestMethod.GET)
    public String showPersoninAnnuaire(
    		HttpServletRequest request,
    		@RequestParam(value = "id", required = false) Long personID) {
		
		HttpSession session = request.getSession();
		Personne pers = personManager.getPerson(personID);
		
	    session.setAttribute("showPers", pers);
	    session.setAttribute("group", groupManager.findGroup(pers.getIdGroup()));
		
	    logger.info("Returning show_person ("+personID+")  view.");
        return "show-person";
    }
	
}
