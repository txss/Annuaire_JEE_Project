/**
 * GroupController is the controller to routes all group request in the url
 * @author Campanella & Magron
 */
package fr.univ.annuaire.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.manager.GroupManager;
import fr.univ.annuaire.manager.PersonManager;

@Controller()
@RequestMapping("group")
public class GroupController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	GroupManager groupManager;
	@Autowired
	PersonManager personManager;
	
	
	/**
	 * Route the request to the view lister_groupes with the attribute groupes in session
	 * the attribute is a collection of GroupPersonnes
	 * @param request to set the attribute for the view
	 * @return the view lister_groupes
	 */
	@RequestMapping(value = "/groups_List", method = RequestMethod.GET)
    public String showGroupsList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("groupes", groupManager.getAllGroups());
    	logger.info("Returning groups_List view");
        return "lister_groupes";
    }
	
	
	/**
	 * This methode return a page to show the detail of group and all person 
	 * in this group.
	 * This methode return two attribute in the view:
	 * - group -> give infos on the group
	 * - showPersonInGroup -> give all person in this group
	 * @param request to set attributes for views
	 * @param groupID get the id of the group for the search
	 * @return the view show_group with group and showPersonInGroup attributes
	 */
	@RequestMapping(value = "/show_group", method = RequestMethod.GET)
    public String showGroupinAnnuaire(
    		HttpServletRequest request,
    		@RequestParam(value = "id", required = false) String groupID) {
		
		HttpSession session = request.getSession();
		session.setAttribute("group", groupManager.findGroup(groupID));
		session.setAttribute("personnes", personManager.findAllPersonInGroup(groupID));
	    
	    logger.info("Returning show_group ("+groupID+")  view.");
        return "show_group";
    }
	
	
	
	@RequestMapping(value = "/add_group", method = RequestMethod.GET)
    public String showAddGroupinAnnuaire(@ModelAttribute GroupPersonnes g, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:/actions/login/sign_in";
		
	    logger.info("Returning add_group view.");
        return "add_group";
    }
	
	
	@RequestMapping(value = "/add_group", method = RequestMethod.POST)
    public String addGroupinAnnuaire(@ModelAttribute GroupPersonnes g, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:/actions/login/sign_in";
		
		groupManager.saveGroup(g);
	    logger.info("Returning add group "+ g.getName() +" view.");
        return "show_group";
    }
}
