package fr.univ.annuaire.test.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;


public class DaoPersonnesTest {

	Dao dao;
	
	@Before
	public void before (){
		dao = new Dao();
		

	}
	
	private Calendar initAndGetCalendar(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1); // <-- months start
		                                    // at 0.
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		return cal;
	}//initAndGetCalendar()
	
	
	@Test (timeout = 2000)
	public void findAllPersons() throws DaoException {
		Collection<Personne> personnes = dao.findAllPersons();
		assertNotNull(personnes);
//		System.out.println(personnes);
	}

	
	@Test (timeout = 2000)
	public void findPersonByID() throws DaoException{
		Personne pers = dao.findPersonByID(2);
		
		Personne p = new Personne();
		p.setId(2);
		p.setFirstName("Josef               ");
		p.setLastName("Cohen               ");
		p.setEmail("test.test@gmail.com");
		p.setWebSite("testdusiteinternet.com");
		Date birthday = new Date(initAndGetCalendar(27, 10, 1991).getTimeInMillis());
		p.setBirthDate(birthday);
		p.setPassWord("D0nneMoiDes$ou$");
		p.setIdGroup("M2FSIL2016");

		assertTrue(p.isEquals(pers));
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void findPersonNotPresent() throws DaoException{
		dao.findPersonByID(100);
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void deletePerson() throws DaoException{
		Personne p = new Personne();
		p.setId(16);
		dao.deletePerson(p);
		
		dao.findPersonByID(24);
	}
	
	
	@Test (timeout = 2000)
	public void savePerson() throws DaoException{
		Personne p = new Personne();
		p.setFirstName("jean");
		p.setLastName("charles louis emile");
		p.setEmail("jean.riolait@live.de");
		p.setIdGroup("57");
		Date birthday = new Date(initAndGetCalendar(27, 10, 1991).getTimeInMillis());
		p.setBirthDate(birthday);
		p.setWebSite("monbeausiteweb.com");
		p.setPassWord("password");
		
		dao.insertPerson(p);
	}
	

	@Test (timeout = 2000)
	public void updatePerson() throws DaoException{
		Personne p = new Personne();
		p.setId(17);
		p.setFirstName("jean-modifier       ");
		p.setLastName("charles louis emile ");
		p.setEmail("jean.riolait@live.de");
		p.setIdGroup("57");
		Date birthday = new Date(initAndGetCalendar(27, 10, 1991).getTimeInMillis());
		p.setBirthDate(birthday);
		p.setWebSite("monbeausiteweb.com");
		p.setPassWord("password");
		
		dao.updatePerson(p);
		assertTrue(p.isEquals(dao.findPersonByID(17)) );
	}


	@Test (timeout = 2000)
	public void findAllPersonsInGroup(){
		Collection<Personne> personnes = dao.findAllPersonsInGroup(57);
		assertNotNull(personnes);
		System.out.println(personnes);
	}
	
	
	@Test (timeout = 2000)
	public void searchKeywordInPersons(){
		Collection<Personne> personnes = dao.searchKeywordInPersons("oh");
		assertNotNull(personnes);
		System.out.println(personnes);
	}
	
}
