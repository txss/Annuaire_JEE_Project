package fr.univ.annuaire.test.controller;

import static org.junit.Assert.*;

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
import fr.univ.annuaire.web.controller.ProfilController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class ProfilControllerTest {

	@Autowired
    private WebApplicationContext wac;
	@Autowired
	ProfilController profilController;
	
	private MockMvc mockMvc;

	
	@Before
	public void init(){
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
	}
	
	@Test(timeout = 2000)
	public void testGet(){
		assertNotNull(profilController.getGroupManager());
		assertNotNull(profilController.getProfilManager());
	}
	
	
	@Test
	public void showProfilRedirect() throws Exception {
		ResultMatcher redirect = MockMvcResultMatchers.redirectedUrl("/actions/login/sign_in");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/profil/show");
        this.mockMvc.perform(builder)
                    .andExpect(redirect);
	}

	
	@Test
	public void showProfilUserConnect() throws Exception {
		Personne p = new Personne();
		GroupPersonnes grp = null;
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("profil");
		ResultMatcher attr1 = MockMvcResultMatchers.model().attribute("gr",  grp);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/profil/show");
		builder.sessionAttr("user", true); // utilisateur connecté
		builder.sessionAttr("pers", p);
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(attr1)
                    .andExpect(viewName);
	}
	
	
	@Test
	public void editProfilGetRedirect() throws Exception {
		ResultMatcher redirect = MockMvcResultMatchers.redirectedUrl("/actions/login/sign_in");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/profil/edit");
        this.mockMvc.perform(builder)
                    .andExpect(redirect);
	}

	
	@Test
	public void editProfilGetUserConnect() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("edit_profil");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/profil/edit");
		builder.sessionAttr("user", true); // utilisateur connecté
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(viewName);
	}
	
	
//	@Test
//	public void editProfilPostRedirect() throws Exception {
//		ResultMatcher redirect = MockMvcResultMatchers.redirectedUrl("/actions/login/sign_in");
//		ResultMatcher flash = MockMvcResultMatchers.flash().attribute("erreur", true);
//		
//		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/profil/edit");
//		builder.flashAttr("erreur", true);
//        this.mockMvc.perform(builder)
//        			.andExpect(flash)
//                    .andExpect(redirect);
//	}
	
}
