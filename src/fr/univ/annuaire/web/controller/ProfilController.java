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

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.manager.ProfilManager;

@Controller()
@RequestMapping("/profil")
public class ProfilController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	ProfilManager profilManager;
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showProfil(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:login/sign_in";
    	logger.info("Returning show_profil view");
        return "profil";
    }
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editProfilGet(@ModelAttribute Personne p, BindingResult result, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:login/sign_in";
    	logger.info("Returning edit_profil_GET view");
        return "edit_profil";
    }
	
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProfilPost(@ModelAttribute @Valid Personne p, BindingResult result, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return "redirect:login/sign_in";

		if (result.hasErrors()) {
    		logger.info("Returning edit_profil_GET view, edit failled: incorrect syntax");
            return "edit_profil";
        }
		
		profilManager.save(p);
		session.setAttribute("pers", p); // update les infos de la personne connecté en session
		
		logger.info("Saving modifications on person(id:"+p.getId()+")");
    	logger.info("Returning edit_profil_POST view");
        return "profil";
    }
}
