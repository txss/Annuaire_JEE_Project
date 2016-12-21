package fr.univ.annuaire.test.dao;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class DaoPersonnesTest {

	@Autowired
	Dao dao;
	
	
	@Test (timeout = 2000)
	public void findAllPersons() throws DaoException {
		Collection<Personne> personnes = dao.findAllPersons();
		assertNotNull(personnes);
	}

	
	@Test (timeout = 2000)
	public void findPersonByID() throws DaoException{
		Personne pers = dao.findPersonByID(89);
		assertNotNull(pers);
	}
	
	
	@Test (timeout = 2500)
	public void findPersonByEmail() throws DaoException{
		String email = "test.test@gmail.com";
		Personne pers = dao.findPersonByEmail(email);
		
		Personne p = new Personne();
		p.setId(88);
		p.setFirstName("test");
		p.setLastName("code-Bien");
		p.setEmail("test.test@gmail.com");
		p.setWebSite("monbeausite.com");
		p.setBirthDate("2012-12-12");
		p.setPassWord("test");
		p.setIdGroup("default");

		assertTrue(p.isEquals(pers));
	}
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void findPersonByEmailError() throws DaoException{
		String email = "jexistePas@gmail.com";
		dao.findPersonByEmail(email);
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void findPersonNotPresent() throws DaoException{
		dao.findPersonByID(0);
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void deletePerson() throws DaoException{
		Personne p = new Personne();
		p.setId(77);
		dao.deletePerson(p);
		
		Personne pers = dao.findPersonByID(77);
		assertNull(pers);
	}
	
	
	@Test (timeout = 2500)
	public void insertPerson() throws DaoException{
		Personne p = new Personne();
		p.setFirstName("jean");
		p.setLastName("charles louis emile");
		p.setEmail("jean.riolait@live.de");
		p.setIdGroup("default");
		p.setBirthDate("1989-05-23");
		p.setWebSite("monbeausiteweb.com");
		p.setPassWord("password");
		
		dao.insertPerson(p);
	}
	

	@Test (timeout = 2500)
	public void updatePerson() throws DaoException{
		Personne p = new Personne();
		p.setId(89);
		p.setFirstName("jean-modifier");
		p.setLastName("charles louis emile ");
		p.setEmail("jean.riolait@live.de");
		p.setIdGroup("default");
		p.setBirthDate("1997-06-06");
		p.setWebSite("monbeausiteweb.com");
		p.setPassWord("password");
		
		dao.updatePerson(p);
		
		assertTrue(p.isEquals(dao.findPersonByID(89)) );
	}


	@Test (timeout = 2000)
	public void findAllPersonsInGroup(){
		Collection<Personne> personnes = dao.findAllPersonsInGroup("default");
		assertNotEquals(0, personnes.size());
	}
	
	
	@Test (timeout = 2000)
	public void searchKeywordInPersonsFalse(){
		Collection<Personne> personnes = dao.searchKeywordInPersons("oh");
		assertEquals(0, personnes.size());
	}
	
	@Test (timeout = 2000)
	public void searchKeywordInPersonsTrue(){
		Collection<Personne> personnes = dao.searchKeywordInPersons("jean");
		System.out.println(personnes);
		assertNotEquals(0, personnes.size());
	}
	
}
