package fr.univ.annuaire.test.jdbcTools;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.svg.Dao;
import fr.univ.annuaire.svg.DaoException;


public class DaoTest {

	Dao dao;
	
	@Before
	public void before (){
		dao = new Dao();
		
		dao.setUrl("jdbc:mysql://localhost/personnes");
		dao.setUser("root");
		dao.setPassword("admin");
	}
	
	@Test (timeout = 2000)
	public void findPersons() throws DaoException {
		Collection<Personne> personnes = dao.findPersons();
		System.out.println(personnes);
	}

}
