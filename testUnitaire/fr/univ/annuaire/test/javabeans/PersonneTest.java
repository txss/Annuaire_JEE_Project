package fr.univ.annuaire.test.javabeans;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.Personne;

public class PersonneTest {

	private Personne p;
	
	
	@Before
	public void init(){
		p = new Personne();
	}
	
	
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
		fail("Not yet implemented");
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
	
}
