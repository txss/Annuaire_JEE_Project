package fr.univ.annuaire.test.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ.annuaire.manager.PersonManager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class PersonManagerTest {

	
	@Autowired
	PersonManager personManager;
	
	
	@Test(timeout = 2000)
	public void getAllPerson() {
		assertTrue(personManager.getAllPerson().size()!=0);
	}

	
	@Test(timeout = 2000)
	public void getPerson(){
		assertNotNull(personManager.getPerson(85));
	}
	
	
	@Test(timeout = 2000)
	public void getPersonFail(){
		assertNull(personManager.getPerson(0));
	}
	
	
	@Test(timeout = 2000)
	public void findAllPersonInGroup(){
		assertTrue(personManager.findAllPersonInGroup("default").size() != 0);
	}
	
	@Test(timeout = 2000)
	public void findAllPersonInGroupEmptyList(){
		assertTrue(personManager.findAllPersonInGroup("existPas").size() == 0);
	}
	
	
	@Test(timeout = 2000)
	public void searchPersonFail(){
		assertTrue(personManager.searchPerson("existPas").size() == 0);
	}
	
	@Test(timeout = 2000)
	public void searchPersonSuccess(){
		assertTrue(personManager.searchPerson("test").size() != 0);
	}
	
}
