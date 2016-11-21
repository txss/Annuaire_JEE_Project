package fr.univ.annuaire.test.javabeans;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.Personne;

public class PersonneTest {

	private Personne p;
	
	
	@Before
	public void init(){
		p = new Personne();
	}
	
	private Calendar initAndGetCalendar(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1); // <-- months start
		                                    // at 0.
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		return cal;
	}//initAndGetCalendar()
	
	
	@Test
	public void iDTest() {
		p.setId(45);
		assertEquals(45, p.getId());
	}

	@Test
	public void passWordTest(){
		p.setPassWord("TestPassW0rd3");
		assertEquals("TestPassW0rd3", p.getPassWord());
	}
	
	@Test
	public void firstNameTest(){
		p.setFirstName("jean");
		assertEquals("jean", p.getFirstName());
	}	
	
	@Test
	public void lastNameTest(){
		p.setLastName("Christophe");
		assertEquals("Christophe", p.getLastName());
	}
	
	@Test
	public void birthDateTest(){
		Date birthday = new Date(initAndGetCalendar(27, 10, 1991).getTimeInMillis());
		p.setBirthDate(birthday);
		assertEquals(birthday, p.getBirthDate());
	}
	
	@Test
	public void emailTest(){
		p.setEmail("jean.riolait@live.de");
		assertEquals("jean.riolait@live.de", p.getEmail());
	}
	
	@Test
	public void webSiteTest(){
		p.setWebSite("https://dearwood.fr/");
		assertEquals("https://dearwood.fr/", p.getWebSite());
	}
	
	@Test
	public void idGroupTest(){
		p.setIdGroup("5");
		assertEquals("5", p.getIdGroup());
	}

	@Test
	public void toStringTest(){
		p.setFirstName("jean");
		p.setLastName("christophe");
		p.setId(0);
		Date birthday = new Date(initAndGetCalendar(27, 10, 1991).getTimeInMillis());
		p.setBirthDate(birthday);
		p.setEmail("test.test@test.com");
		p.setWebSite("monbeausite.com");
		p.setIdGroup("5");

		assertEquals("\nid: 0\nprenom: jean\nnom: christophe\nemail: test.test@test.com\nwebSite: monbeausite.com\nGroupe: 5", p.toString());
	}
	
}
