package fr.univ.annuaire.test.dao;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.svg.Dao;
import fr.univ.annuaire.svg.DaoException;


public class DaoTest {

	Dao dao;
	
	@Before
	public void before (){
		dao = new Dao();
		
		dao.setUrl("jdbc:mysql://localhost/annuaire");
		dao.setUser("admin");
		dao.setPassword("admin");
	}
	
	
	@Test (timeout = 2000)
	public void findAllPersons() throws DaoException {
		Collection<Personne> personnes = dao.findAllPersons();
		assertNotEquals(null, personnes);
//		System.out.println(personnes);
	}

	@Test (timeout = 2000)
	public void findPerson(){
		Personne pers = dao.findPerson(19);
		System.out.println(pers);
	}
	
	
	@Test (timeout = 2000)
	public void findAllGroups() {
		Collection<GroupPersonnes> groupPersonnes = dao.findAllGroups();
		assertNotEquals(null, groupPersonnes);
//		System.out.println(groupPersonnes);
	}
	
	
}
