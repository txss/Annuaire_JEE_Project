package fr.univ.annuaire.test.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.manager.ProfilManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class ProfilManagerTest {

	@Autowired
	ProfilManager profilManager;
	
	
	@Test
	public void updateSuccess() {
		Personne pers = new Personne();
		pers.setId(88);
		pers.setFirstName("test");
		pers.setLastName("code-Bien");
		pers.setPassWord("test");
		pers.setBirthDate("2012-12-12");
		pers.setWebSite("monbeausite.com");
		pers.setIdGroup("default");
		pers.setEmail("test.test@gmail.com");
		
		assertTrue(profilManager.update(pers));
	}

	
	@Test
	public void updateFailWrongID() {
		Personne pers = new Personne();
		pers.setId(0);
		pers.setFirstName("test");
		pers.setLastName("code-Bien");
		pers.setPassWord("test");
		pers.setBirthDate("2012-12-12");
		pers.setWebSite("monbeausite.com");
		pers.setIdGroup("default");
		pers.setEmail("test.test@gmail.com");
		
		assertFalse(profilManager.update(pers));
	}
	
	@Test
	public void updateFailWrongPwd() {
		Personne pers = new Personne();
		pers.setId(88);
		pers.setFirstName("test");
		pers.setLastName("code-Bien");
		pers.setPassWord("mauvaisPassword");
		pers.setBirthDate("2012-12-12");
		pers.setWebSite("monbeausite.com");
		pers.setIdGroup("default");
		pers.setEmail("test.test@gmail.com");
		
		assertFalse(profilManager.update(pers));
	}
	
	
//	@Test(timeout = 2000)
//	public void deletePerson(){
//		Personne pers = new Personne();
//		pers.setId(88);
//		pers.setFirstName("test");
//		pers.setLastName("code-Bien");
//		pers.setPassWord("mauvaisPassword");
//		pers.setBirthDate("2012-12-12");
//		pers.setWebSite("monbeausite.com");
//		pers.setIdGroup("default");
//		pers.setEmail("test.test@gmail.com");
//		
//		profilManager.deletePerson(pers);
//	}
	
}
