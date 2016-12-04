package fr.univ.annuaire.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping("/accueil")
public class AccueilController {

protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "", method = RequestMethod.GET)
    public String showAccueil() {
    	logger.info("Returning accueil view");
        return "accueil";
    }
	
}
