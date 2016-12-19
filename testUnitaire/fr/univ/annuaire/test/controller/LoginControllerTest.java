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

import fr.univ.annuaire.web.controller.LoginController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class LoginControllerTest {

	@Autowired
    private WebApplicationContext wac;
	@Autowired
	LoginController loginController;
	
	private MockMvc mockMvc;

	
	@Before
	public void init(){
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
	}
	
	@Test(timeout = 2000)
	public void testGet(){
		assertNotNull(loginController.getGroupManager());
		assertNotNull(loginController.getLoginManager());
	}
	
	
	@Test(timeout = 2000)
	public void login() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("login");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/login/sign_in");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(viewName);
	}

	
//	@Test(timeout = 2000)
//	public void loginFormRedirect() throws Exception {
//		ResultMatcher viewName = MockMvcResultMatchers.view().name("login");
//		
//		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/login/sign_in");
//		builder.param("email", "");
//		builder.param("passWord", "re");
//        this.mockMvc.perform(builder)
//                    .andExpect(viewName);
//	}
	
	@Test(timeout = 2000)
	public void sign_up() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher viewName = MockMvcResultMatchers.view().name("sign-up");
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/login/sign_up");
        this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andExpect(viewName);
	}

	
//	@Test(timeout = 2000)
//	public void sign_upForm() throws Exception {
//		ResultMatcher viewName = MockMvcResultMatchers.view().name("sign-up");
//		
//		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/login/sign_up");
//		builder.param("id", "12");
//		builder.param("firstName", "k");
//		builder.param("lastName", "test");
//		builder.param("birthDate", "2012-12-12");
//		builder.param("email", "test");
//		builder.param("webSite", "test");
//		builder.param("idGroup", "default");
//		builder.param("password", "default");
//        this.mockMvc.perform(builder)
//                    .andExpect(viewName);
//	}
	
	
	@Test(timeout = 2000)
	public void logout() throws Exception {
		Object user = null;
		ResultMatcher redirect = MockMvcResultMatchers.redirectedUrl("sign_in");
		ResultMatcher attr1 = MockMvcResultMatchers.model().attribute("user",  user);
		
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/login/logout");
        this.mockMvc.perform(builder)
        			.andExpect(attr1)
                    .andExpect(redirect);
	}
}
