package fr.univ.annuaire.test.utility;

import org.junit.Test;

import fr.univ.annuaire.utility.EmailUtility;

public class EmailTest {
	

	@Test(timeout = 2500)
	public void test() {
		EmailUtility.sendEmail("votre.email@gmail.com", "password");
	}

}
