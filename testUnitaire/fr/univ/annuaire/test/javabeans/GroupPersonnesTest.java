package fr.univ.annuaire.test.javabeans;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.beans.Personne;

public class GroupPersonnesTest {

	GroupPersonnes g;
	ArrayList<Personne> listPersone;
	ArrayList<Personne> listPersone2;
	
	@Before
	public void init(){
		g = new GroupPersonnes();
		listPersone = new ArrayList<Personne>();
		listPersone2 = new ArrayList<Personne>();
		
		Personne p0 = new Personne();
		p0.setId(0);
		p0.setFirstName("jean");
		p0.setLastName("christophe");
		
		Personne p1 = new Personne();
		p1.setId(1);
		p1.setFirstName("charles");
		p1.setLastName("luc");
		
		Personne p2 = new Personne();
		p2.setId(2);
		p2.setFirstName("florian");
		p2.setLastName("sansnom");
		
		listPersone.add(p1);
		
		listPersone2.add(p0);
		listPersone2.add(p1);
		listPersone2.add(p2);
	}

	@Test
	public void testId() {
		g.setId(18);
		assertEquals(18, g.getId());
	}

	@Test
	public void testName() {
		g.setName("FSIL");
		assertEquals("FSIL", g.getName());
	}

	@Test
	public void testPersonneInGroupNULL() {
		g.setPersonneInGroup(null);
		assertEquals(null, g.getPersonneInGroup());
	}
	
	@Test
	public void testPersonneInGroup1p() {
		g.setPersonneInGroup(listPersone);
		assertEquals(listPersone, g.getPersonneInGroup());
	}

	@Test
	public void testPersonneInGroupMultP() {
		g.setPersonneInGroup(listPersone2);
		assertEquals(listPersone2, g.getPersonneInGroup());
	}
	
	@Test
	public void toStringTest(){
		g.setId(2);
		g.setName("ISL");

		assertEquals("id: 2\nnom: ISL", g.toString());
	}
	
}
