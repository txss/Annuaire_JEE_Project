package fr.univ.annuaire.test.dao;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.svg.Dao;
import fr.univ.annuaire.svg.DaoException;

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
	public void findGroupByID() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId(2);
		
		GroupPersonnes res = dao.findGroupByID(g);
		assertEquals(g.getId(), res.getId());
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void findGroupByIDAbsent() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId(000);
		
		dao.findGroupByID(g);
	}
	
	
	@Test (timeout = 2000)
	public void findGroupByName(){
		GroupPersonnes g = new GroupPersonnes();
		g.setName("ISL");
		
		dao.findGroupByName(g);
		assertEquals("ISL", g.getName());
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void deleteGroupByID() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId(777);
		
		dao.deleteGroupByID(g);
		dao.findGroupByID(g);
	}
	
	
	@Test (timeout = 2000)
	public void saveGroup() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId(777);
		g.setName("ID");
		
		dao.saveGroup(g);
		dao.findGroupByID(g);
	}
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void saveGroupDuplicate() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId(777);
		g.setName("ID");
		
		dao.saveGroup(g);
	}
	
	@Test (timeout = 2000)
	public void UpdateGroupByID() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId(55);
		g.setName("ISSL");
		
		dao.saveGroup(g);
		
		g.setName("ISL");
		dao.UpdateGroupByID(g);
		
		GroupPersonnes group = dao.findGroupByID(g);
		assertEquals("ISL",	group.getName());
	}
	
}
