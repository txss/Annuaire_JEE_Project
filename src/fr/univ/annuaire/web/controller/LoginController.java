/**
 * LoginController is the controller to routes all login request in the url
 * The user need to call this methode to get authenticate.
 * The methode logout is implement in the controller to.
 * Every action in the application, or in Url, wo need to be login  to be done redirect to the methode login in this controller
 * @author Campanella & Magron
 */
package fr.univ.annuaire.web.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

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
import fr.univ.annuaire.beans.Login;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.manager.GroupManager;
import fr.univ.annuaire.manager.LoginManager;

@Controller()
@RequestMapping("/login")
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	LoginManager loginManager;
	@Autowired
	GroupManager groupManager;
	
	
	public LoginManager getLoginManager() {
		return loginManager;
	}
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
	public GroupManager getGroupManager() {
		return groupManager;
	}
	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}


	/**
	 * This methode return the login view to the user.
	 * The user need to use this methode to get the login form on the login view
	 * @param l the bean login use to validate the data submit by the user in the login form
	 * @param request set attributes user in the session context
	 * @return the login view
	 */
    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String login(@ModelAttribute Login l, HttpServletRequest request) {
    	HttpSession session = request.getSession();
	    session.setAttribute("user", null);
    	logger.info("Returning login view");
        return "login";
    }

    
    /**
     * This methode will authenticate, or not, an user.
     * It 's call the loginManager to execute request on database
     * @param l the bean use to validate the user data submit
     * @param result bind data 
     * @param redirectAttributes set parameters for the user (flash messages) if error in authentification
     * @param request set the attributes in the user session
     * @return views
     */
    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public String loginForm(@ModelAttribute @Valid Login l, 
    							BindingResult result, 
    							final RedirectAttributes redirectAttributes, 
    							HttpServletRequest request){
    	
    	if (result.hasErrors()) {
    		logger.info("Returning log view, auth failled: incorrect syntax");
            return "login";
        }
    	
    	Personne pers = loginManager.checkLogin(l);
    	
    	if (pers != null){
    		HttpSession session = request.getSession();
    	    session.setAttribute("user", true);
    	    session.setAttribute("pers", pers); // envoie les infos de la personne connecté en session
    		logger.info("Returning accueil view, auth success");
            return "redirect:/actions/accueil";
    	}
    	
    	redirectAttributes.addFlashAttribute("erreur", true);
    	logger.info("Returning login view, auth failed: wrong identifiants");
        return "redirect:sign_in";
    }
    
    
	/**
	 * This methode allow someone to register on the annuaire.
	 * @param request
	 * @return the view to add a account on the annuaire
	 */
    @RequestMapping(value = "/sign_up", method = RequestMethod.GET)
    public String sign_up(@ModelAttribute Personne p, BindingResult result) {
    	logger.info("Returning sign_up view");
        return "sign-up";
    }
    

    /**
     * This methode check sent the values submit by the user in the sign_up form
     * redirect to the sign_in view if the person saving is a success
     * redirect to sign_up view if errors or if the email is already in database
     * @param p the person to save
     * @param redirectAttributes set the flash message 
     * @param result bind the result with bean
     * @return String view name
     */
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String sign_upForm(@ModelAttribute @Valid Personne p,
    						BindingResult result,
							final RedirectAttributes redirectAttributes) {

    	if (result.hasErrors()) {
    		logger.info("Returning sign_up view, sign_up failed: incorrect syntax");
            return "sign-up";
        }
    	
    	if( ! loginManager.saveNewPerson(p)){
    		redirectAttributes.addFlashAttribute("erreur", true);
    		logger.info("Returning sign_up view, email already exist");
    		return "redirect:sign_up";
    	}else{
    		redirectAttributes.addFlashAttribute("success", true);
    		logger.info("Returning accueil view, new Person in Annuaire: " + p);
    	}
    	
        return "redirect:sign_in";
    }
    
    
    /**
     * This methode is used to logout an user.
     * @param request
     * @return redirect to the login page
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
    	HttpSession session = request.getSession();
	    session.setAttribute("user", null);
    	logger.info("lOGOUT and returning login view");
        return "redirect:sign_in";
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
    
}