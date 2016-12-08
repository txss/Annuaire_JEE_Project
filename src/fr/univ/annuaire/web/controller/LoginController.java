/**
 * LoginController is the controller to routes all login request in the url
 * The user need to call this methode to get authenticate.
 * The methode logout is implement in the controller to.
 * Every action in the application, or in Url, wo need to be login  to be done redirect to the methode login in this controller
 * @author Campanella & Magron
 */
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.univ.annuaire.beans.Login;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.manager.LoginManager;

@Controller()
@RequestMapping("/login")
public class LoginController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	LoginManager manager;
    
	
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
    public String loginRedirect(@ModelAttribute @Valid Login l, 
    							BindingResult result, 
    							final RedirectAttributes redirectAttributes, 
    							HttpServletRequest request){
    	
    	if (result.hasErrors()) {
    		logger.info("Returning log view, auth failled: incorrect syntax");
            return "login";
        }
    	
    	Personne pers = manager.checkLogin(l);
    	if (pers != null){
    		HttpSession session = request.getSession();
    	    session.setAttribute("user", true);
    	    session.setAttribute("pers", pers); // envoie les infos de la personne connecté en session
    		logger.info("Returning accueil view, auth success");
            return "redirect:/actions/accueil";
    	}
    	
    	redirectAttributes.addFlashAttribute("error", "Identifiant ou mot de passe incorect.");
    	logger.info("Returning login view, auth failled: wrong identifiants");
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
    
}