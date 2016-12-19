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
import fr.univ.annuaire.web.controller.GroupController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class GroupControllerTest {
	
	
	@Autowired
    private WebApplicationContext wac;
	@Autowired
	GroupController groupController;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void init(){
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
	}
	
	@Test(timeout = 2500)
	public void showGroupsList() throws Exception {
		Collection<GroupPersonnes> groupPersonnes = null;
		
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher attr = MockMvcResultMatchers.model().attribute("groupes",  groupPersonnes); // ce que j'attend -> une liste de personnes
		ResultMatcher viewName = MockMvcResultMatchers.view().name("lister_groupes");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/group/groups_List");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(attr)
                    .andExpect(viewName);
	}
	
	
	@Test (timeout = 2000)
	public void testGet(){
		assertNotNull(groupController.getGroupManager());
		assertNotNull(groupController.getPersonManager());
	}
	
	@Test(timeout = 3500)
	public void showGroupinAnnuaire() throws Exception{
		GroupPersonnes group = null;
		Collection<Personne> personnes = null; 
		
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("show_groupe");
		ResultMatcher attr1 = MockMvcResultMatchers.model().attribute("group",  group);
		ResultMatcher attr2 = MockMvcResultMatchers.model().attribute("personnes",  personnes);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/group/show_group?id='default'");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(attr1)
                    .andExpect(attr2)
                    .andExpect(viewName);
	}
	
	@Test(timeout = 2500)
	public void showAddGroupinAnnuaireRedirect() throws Exception {
		ResultMatcher redirect = MockMvcResultMatchers.redirectedUrl("/actions/login/sign_in");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/group/add_group");
        this.mockMvc.perform(builder)
                    .andExpect(redirect);
	}
	
	@Test(timeout = 2500)
	public void showAddGroupinAnnuaire() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("add_groupe");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/group/add_group");
		builder.sessionAttr("user", true);
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(viewName);
	}
	
	@Test(timeout = 2500)
	public void addGroupinAnnuairePostRedirect() throws Exception{
		ResultMatcher redirect = MockMvcResultMatchers.redirectedUrl("/actions/login/sign_in");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/group/add_group");
        this.mockMvc.perform(builder)
                    .andExpect(redirect);
	}
	
	@Test(timeout = 2500)
	public void addGroupinAnnuairePostOK() throws Exception{
		ResultMatcher viewName = MockMvcResultMatchers.view().name("show_group");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/group/add_group");
		builder.sessionAttr("user", true);
		builder.param("name", "default"); // data in form
        this.mockMvc.perform(builder)
                    .andExpect(viewName);
	}
}
