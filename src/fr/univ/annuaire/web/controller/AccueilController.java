/**
 * Accueil controller is the controller to redirect the user on the accueil view
 * @author Campanella & Magron
 */
package fr.univ.annuaire.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class AccueilController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());


    /**
     * This methode redirect the user (login or not) to the accueil view 
     */
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response){

        logger.info("Returning accueil view");
        return new ModelAndView("accueil");
    }

}