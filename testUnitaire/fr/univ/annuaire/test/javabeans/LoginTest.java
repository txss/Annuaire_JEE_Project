package fr.univ.annuaire.test.javabeans;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.Login;

public class LoginTest {

	Login login;
	
	@Before
	public void init(){
		login = new Login();
	}
	
	@Test
	public void email() {
		login.setEmail("test.tes@test.fr");
		assertEquals("test.tes@test.fr", login.getEmail());
	}
	
	@Test
	public void password() {
		login.setPassWord("testtest");
		assertEquals("testtest", login.getPassWord());
	}

	@Test
	public void toStringTest() {
		login.setPassWord("testtest");
		login.setEmail("test.tes@test.fr");
		assertEquals("Email: test.tes@test.fr --> pwd: testtest", login.toString());
	}

	
}
