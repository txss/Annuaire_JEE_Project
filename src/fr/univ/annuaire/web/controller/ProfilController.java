/**
 * ProfilController is the controller to routes all profils request in the url
 * Every action in the application, or in Url, about the person profil need to be done in this controller
 * Show person, show all person in database..
 * @author Campanella & Magron
 */
package fr.univ.annuaire.web.controller;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;

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

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.manager.GroupManager;
import fr.univ.annuaire.manager.ProfilManager;

@Controller()
@RequestMapping("/profil")
public class ProfilController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	ProfilManager profilManager;
	@Autowired
	GroupManager groupManager;
	
	
	/**
	 * This methode check if the user is authenticate and redirect to the profile view
	 * if the user is not connect, he will be redirect to the login view
	 * @param request useful to check if the user is connect
	 * @return the profil view name
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showProfil(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:/actions/login/sign_in";
		
		Personne p = (Personne) session.getAttribute("pers");
		session.setAttribute("gr", groupManager.findGroup(p.getIdGroup()));
    	logger.info("Returning show_profil view");
        return "profil";
    }
	
	
	/**
	 * This methode check if the user is authenticate and redirect to view edit_profil
	 * if the user is not connect, he will be redirect to the login view
	 * @param p the bean correspondance
	 * @param result to binding the result that will be submit by the user
	 * @param request check if the user is authenticate
	 * @return the edit profil view name
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editProfilGet(@ModelAttribute Personne p, 
					    		BindingResult result, 
					    		HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:/actions/login/sign_in";
		
    	logger.info("Returning edit_profil_GET view");
        return "edit_profil";
    }
	
	
	/**
	 * This methode check if the user is authenticate and redirect to the profile view
	 * if the user is not connect, he will be redirect to the login view
	 * then update the value of each parameters to the person in database.
	 * @param p
	 * @param result
	 * @param redirectAttributes
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProfilPost(	@ModelAttribute @Valid Personne p, 
						    		BindingResult result,
						    		final RedirectAttributes redirectAttributes,
						    		HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:/actions/login/sign_in";

		if (result.hasErrors()) {
    		logger.info("Returning edit_profil_GET view, edit failled: incorrect syntax");
            return "edit_profil";
        }
		
		if(profilManager.update(p)){
			session.setAttribute("pers", p); // update les infos de la personne connecté en session
			logger.info("Saving modifications on person(id:"+p.getId()+")");
	    	logger.info("Returning edit_profil_POST view");
		}else{
			redirectAttributes.addFlashAttribute("erreur", true);
			return "redirect:edit";
		}
		
	    return "profil";
    }
	
	
	
	// Type complexe
	@ModelAttribute("groupList")
	public Map<String, String> groupesTypes() {
	    Map<String, String> groupes = new LinkedHashMap<>();
	    Collection<GroupPersonnes> gr = groupManager.getAllGroups();
	    
	    Iterator<GroupPersonnes> itr = gr.iterator();
	    while(itr.hasNext()){
	    	GroupPersonnes groupPersonnes = itr.next();
	    	groupes.put(groupPersonnes.getId(), groupPersonnes.getName());
	    }
	    
	    return groupes;
	}
	
	
	/**
	 * This methode check if the user is authenticate, 
	 * if the user is not connect, he will be redirect to the login view.
	 * If the user is authenticate this action will erase all data about it in te database.
	 * @param request to check if the user is authenticate
	 * @param redirectAttributes add flash message
	 * @return redirect to sign_in view
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProfil(	HttpServletRequest request,
    							final RedirectAttributes redirectAttributes) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:/actions/login/sign_in";
		
		Personne pers = (Personne) session.getAttribute("pers");
		profilManager.deletePerson(pers);
		
		redirectAttributes.addFlashAttribute("erase", true);
    	logger.info("Returning profil view, erase person in database");
        return "redirect:/actions/login/sign_in";
    }
	
}
