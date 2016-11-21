package fr.univ.annuaire.test.dao;


import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;
import fr.univ.annuaire.svg.JdbcTools;

public class DaoPersonnesErrorTest {

	Dao dao;
	
	@Before
	public void before () throws ClassNotFoundException{
		dao = new Dao();
		
		dao.setDriver(JdbcTools.POSTGRESQL_DRIVER);
		dao.setUrl("jdbc:postgresql://vulgamatiqu");
		dao.setUser("");
		dao.setPassword("!");
	}

	
	@Test (timeout = 2000, expected = SQLException.class)
	public void findAllPersonsErr() throws DaoException {
		dao.findAllPersons();
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void findAllPersonsInGroupErr(){
		dao.findAllPersonsInGroup(57);
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void findPersonByIDErr() throws DaoException{
		dao.findPersonByID(2);
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void insertPersonErr() throws DaoException{
		Personne p = new Personne();
		p.setFirstName("jean");
		p.setLastName("charles louis emile");
		p.setEmail("jean.riolait@live.de");
		p.setIdGroup("57");
		p.setWebSite("monbeausiteweb.com");
		p.setPassWord("password");
		
		dao.insertPerson(p);
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void deletePersonErr() throws DaoException{
		Personne p = new Personne();
		p.setId(16);
		dao.deletePerson(p);
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void updatePersonErr() throws DaoException{
		Personne p = new Personne();
		p.setId(17);
		p.setFirstName("jean-modifier       ");
		p.setLastName("charles louis emile ");
		p.setEmail("jean.riolait@live.de");
		p.setIdGroup("57");
		p.setWebSite("monbeausiteweb.com");
		p.setPassWord("password");
		dao.updatePerson(p);
	}
}
