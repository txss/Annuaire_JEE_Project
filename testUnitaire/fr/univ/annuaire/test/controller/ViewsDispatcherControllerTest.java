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

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.web.controller.ViewsDispatcherController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class ViewsDispatcherControllerTest {

	@Autowired
    private WebApplicationContext wac;
	@Autowired
	ViewsDispatcherController viewsDispatcherController;
	
	private MockMvc mockMvc;

	
	@Before
	public void init(){
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
	}
	
	@Test(timeout = 2000)
	public void testGet(){
		assertNotNull(viewsDispatcherController.getGroupManager());
		assertNotNull(viewsDispatcherController.getPersonManager());
	}
	
	
	@Test
	public void showAccueil() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("accueil_view");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/accueil");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(viewName);
	}

	@Test
	public void searchinAnnuaireAbsent() throws Exception {
		String string = null;
		Collection<Personne> personnes = null;
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("searcher");
		ResultMatcher attr1 = MockMvcResultMatchers.model().attribute("time", string );
		ResultMatcher attr2 = MockMvcResultMatchers.model().attribute("personnes", personnes );
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/search?searcher=existpas");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(attr1)
                    .andExpect(attr2)
                    .andExpect(viewName);
	}
	
	@Test
	public void searchinAnnuaire() throws Exception {
		String string = null;
		Collection<Personne> personnes = null;
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("searcher");
		ResultMatcher attr1 = MockMvcResultMatchers.model().attribute("time", string );
		ResultMatcher attr2 = MockMvcResultMatchers.model().attribute("personnes", personnes );
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/search?searcher=jean");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(attr1)
                    .andExpect(attr2)
                    .andExpect(viewName);
	}
	
	@Test
	public void searchinAnnuaireEmptySearch() throws Exception {
		String string = null;
		Collection<Personne> personnes = null;
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("searcher");
		ResultMatcher attr1 = MockMvcResultMatchers.model().attribute("time", string );
		ResultMatcher attr2 = MockMvcResultMatchers.model().attribute("personnes", personnes );
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/search?searcher=");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(attr1)
                    .andExpect(attr2)
                    .andExpect(viewName);
	}
}
