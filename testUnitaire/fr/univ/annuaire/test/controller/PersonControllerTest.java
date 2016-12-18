package fr.univ.annuaire.test.controller;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.web.controller.PersonController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class PersonControllerTest {

	
	@Autowired
    private WebApplicationContext wac;
	@Autowired
	PersonController personController;
	
	private MockMvc mockMvc;

	
	
	@Before
	public void init(){
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
	}
	
	
	@Test(timeout = 2000)
	public void testGet(){
		assertNotNull(personController.getGroupManager());
		assertNotNull(personController.getPersonManager());
	}
	
	
	@Test
	public void person_List() throws Exception {
		Collection<Personne> personnes = null;
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("lister");
		ResultMatcher attr = MockMvcResultMatchers.model().attribute("personnes", personnes);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/person/person_List");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(attr)
                    .andExpect(viewName);
	}
	
	
	@Test
	public void showPersoninAnnuaire() throws Exception {
		GroupPersonnes gr = null;
		Personne pers = null;
		
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("show-person");
		ResultMatcher attr1 = MockMvcResultMatchers.model().attribute("showPers", pers);
		ResultMatcher attr2 = MockMvcResultMatchers.model().attribute("group", gr);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/person/show_person?id=85");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(attr1)
                    .andExpect(attr2)
                    .andExpect(viewName);
	}

}
