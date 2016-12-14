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
			redirectAttributes.addFlashAttribute("error", "Le mot de passe ne corespond pas.");
			System.out.println("ERROR le mot de passe coresp pas"); // TODO
			return "edit_profil";
		}
		
	    return "profil";
    }
	
	
	
	// Type complexe
	@ModelAttribute("groupList")
	public Map<String, String> productTypes() {
	    Map<String, String> groupes = new LinkedHashMap<>();
	    Collection<GroupPersonnes> gr = groupManager.getAllGroups();
	    
	    Iterator<GroupPersonnes> itr = gr.iterator();
	    while(itr.hasNext()){
	    	GroupPersonnes groupPersonnes = itr.next();
	    	groupes.put(groupPersonnes.getId(), groupPersonnes.getName());
	    }
	    
	    return groupes;
	}
	
	
	
}
