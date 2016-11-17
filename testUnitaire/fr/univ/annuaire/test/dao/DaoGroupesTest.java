package fr.univ.annuaire.test.dao;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.svg.Dao;

public class DaoGroupesTest {

Dao dao;
	
	@Before
	public void before (){
		dao = new Dao();
		
		dao.setUrl("jdbc:mysql://localhost/annuaire?useSSL=false");
		dao.setUser("admin");
		dao.setPassword("admin");
	}
	
	
	@Test (timeout = 2000)
	public void findAllGroups() {
		Collection<GroupPersonnes> groupPersonnes = dao.findAllGroups();
		assertNotNull(groupPersonnes);
//		System.out.println(groupPersonnes);
	}

	
	@Test (timeout = 2000)
	public void deleteGroupByID(){
		GroupPersonnes g = new GroupPersonnes();
		g.setId(5);
		
		dao.deleteGroupByID(g);
	}
	
}
