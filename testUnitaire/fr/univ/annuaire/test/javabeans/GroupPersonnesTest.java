package fr.univ.annuaire.test.javabeans;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.GroupPersonnes;

public class GroupPersonnesTest {

	GroupPersonnes g;
	
	@Before
	public void init(){
		g = new GroupPersonnes();
	}

	@Test
	public void testId() {
		g.setId("M2FSIL2016");
		assertEquals(18, g.getId());
	}

	@Test
	public void testName() {
		g.setName("FSIL");
		assertEquals("FSIL", g.getName());
	}
	
	@Test
	public void toStringTest(){
		g.setId("M2FSIL2016");
		g.setName("ISL");

		assertEquals("id: 2\nnom: ISL", g.toString());
	}
	
}
