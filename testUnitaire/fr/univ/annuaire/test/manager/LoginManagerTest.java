package fr.univ.annuaire.test.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ.annuaire.beans.Login;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.manager.LoginManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class LoginManagerTest {
	
	@Autowired
	LoginManager loginManager;

	
	@Test (timeout = 2000)
	public void checkLoginFailWrongEmail() {
		Login login = new Login();
		login.setEmail("existpas@gmail.com");
		login.setPassWord("mauvaisPassWord!");
		
		assertNull(loginManager.checkLogin(login));
	}

	@Test(timeout = 2000)
	public void testGet(){
		assertNotNull(loginManager.getDao());
	}
	
	@Test (timeout = 2000)
	public void checkLoginFailWrongPassword() {
		Login login = new Login();
		login.setEmail("test.test@gmail.com");
		login.setPassWord("mauvaisPassWord!");
		
		assertNull(loginManager.checkLogin(login));
	}
	
	@Test (timeout = 2000)
	public void checkLoginSuccess() {
		Login login = new Login();
		login.setEmail("test.test@gmail.com");
		login.setPassWord("test");
		
		assertNotNull(loginManager.checkLogin(login));
	}
	
	
	@Test (timeout = 2000)
	public void saveNewPersonFailMissingArg() {
		Personne pers = new Personne();
		pers.setFirstName("jean");
		pers.setLastName("code-Bien");
		pers.setPassWord("codeBien");
		pers.setBirthDate("2012-12-12");
		pers.setEmail("jean.code-bien@gmail.com");
		
		assertFalse(loginManager.saveNewPerson(pers));
	}
	
	@Test (timeout = 2000)
	public void saveNewPersonFailDuplicateEmail() {
		Personne pers = new Personne();
		pers.setFirstName("jean");
		pers.setLastName("code-Bien");
		pers.setPassWord("codeBien");
		pers.setBirthDate("2012-12-12");
		pers.setEmail("test.test@gmail.com");
		
		assertFalse(loginManager.saveNewPerson(pers));
	}
	
	
	@Test (timeout = 2500)
	public void saveNewPersonSuccess() { // TODO set new person with different email
		Personne pers = new Personne();
		pers.setFirstName("jean");
		pers.setLastName("code-Bien");
		pers.setPassWord("codeBien");
		pers.setIdGroup("default");
		pers.setWebSite("");
		pers.setBirthDate("2012-12-12");
		pers.setEmail("jean.code-bien1@gmail.com");
		
		assertTrue(loginManager.saveNewPerson(pers));
	}
	
	@Test (timeout = 2500)
	public void getPerson(){
		assertNotNull(loginManager.getPerson("test.test@gmail.com"));
	}
	
	@Test (timeout = 2500)
	public void getPersonNull(){
		assertNull(loginManager.getPerson("existPas@gmail.com"));
	}
}
