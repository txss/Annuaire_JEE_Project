package fr.univ.annuaire.test.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import fr.univ.annuaire.web.controller.AccueilController;

public class AccueilControllerTest {

	
	AccueilController accueilController;
	
	@Before
	public void init(){
		accueilController = new AccueilController();
	}
	
	@Test
	public void accueil() {
		ModelAndView result = accueilController.handleRequest(null, null);
		assertEquals("accueil", result.getViewName());
	}

}
