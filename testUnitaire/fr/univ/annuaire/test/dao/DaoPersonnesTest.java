package fr.univ.annuaire.test.dao;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.svg.Dao;
import fr.univ.annuaire.svg.DaoException;


public class DaoPersonnesTest {

	Dao dao;
	
	@Before
	public void before (){
		dao = new Dao();
		
		dao.setUrl("jdbc:mysql://localhost/annuaire?useSSL=false");
		dao.setUser("admin");
		dao.setPassword("admin");
	}
	
	
	@Test (timeout = 2000)
	public void findAllPersons() throws DaoException {
		Collection<Personne> personnes = dao.findAllPersons();
		assertNotNull(personnes);
//		System.out.println(personnes);
	}

	
	@Test (timeout = 2000)
	public void findPerson() throws DaoException{
		Personne pers = dao.findPerson(21);
		assertNotNull(pers);
//		System.out.println(pers);
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void findPersonNotPresent() throws DaoException{
		dao.findPerson(100);
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void deletePerson() throws DaoException{
		Personne p = new Personne();
		p.setId(24);
		dao.deletePersonByID(p);
		
		dao.findPerson(24);
	}
	
	
	@Test (timeout = 2000)
	public void savePerson() throws DaoException{
		Personne p = new Personne();
		p.setFirstName("jean");
		p.setLastName("charles louis emile");
		p.setEmail("jean.riolait@live.de");
		p.setIdGroup(4);
		p.setBirthDate("18/01/1998");
		p.setWebSite("monbeausiteweb.com");
		p.setPassWord("password");
		
		dao.saveNewPerson(p);
	}
	

	@Test (timeout = 2000)
	public void updatePerson() throws DaoException{
		Personne p = new Personne();
		p.setId(21);
		p.setFirstName("jean-modifier");
		p.setLastName("charles louis emile");
		p.setEmail("jean.riolait@live.de");
		p.setIdGroup(4);
		p.setBirthDate("18/01/1998");
		p.setWebSite("monbeausiteweb.com");
		p.setPassWord("password");
		
		dao.updatePerson(p);
		assertTrue(p.isEquals(dao.findPerson(21)));
	}

	
	@Test (timeout = 2000)
	public void findAllGroups() {
		Collection<GroupPersonnes> groupPersonnes = dao.findAllGroups();
		assertNotNull(groupPersonnes);
//		System.out.println(groupPersonnes);
	}


}
