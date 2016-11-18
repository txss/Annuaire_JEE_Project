package fr.univ.annuaire.test.dao;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;
import fr.univ.annuaire.svg.JdbcTools;

public class DaoGroupesTest {

Dao dao;
	
	@Before
	public void before () throws ClassNotFoundException{
		dao = new Dao();
		

	}
	
	
	@Test (timeout = 2000)
	public void findAllGroups() {
		Collection<GroupPersonnes> groupPersonnes = dao.findAllGroups();
		assertNotNull(groupPersonnes);
//		System.out.println(groupPersonnes);
	}

	
	@Test (timeout = 2000)
	public void findGroup() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("M2FSIL2016");
		
		GroupPersonnes res = dao.findGroup(g);
		assertEquals(g.getId(), res.getId());
	}
	
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void findGroupByIDAbsent() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("00000");
		
		dao.findGroup(g);
	}
	
	
	@Test (timeout = 2000)
	public void findGroupByName() throws DaoException{
		GroupPersonnes g = dao.findGroupByName("M2 FSIL 2015/2016");
		
		assertEquals("M2 FSIL 2015/2016", g.getName());
	}
	
	//TODO foreignkey
	@Test (timeout = 2000, expected = DaoException.class)
	public void deleteGroupByID() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("M2FSIL2018");
		
		dao.deleteGroup(g);
		dao.findGroup(g);
	}
	
	
	@Test (timeout = 2000)
	public void saveGroup() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("M2FSIL2018");
		g.setName("ID");
		
		dao.saveGroup(g);
		dao.findGroup(g);
	}
	
	@Test (timeout = 2000, expected = DaoException.class)
	public void saveGroupDuplicate() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("M2FSIL2018");
		g.setName("ID");
		
		dao.saveGroup(g);
	}
	
	@Test (timeout = 2000)
	public void UpdateGroupByID() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("777");
		g.setName("ISSL");
		
		dao.UpdateGroup(g);
		
		GroupPersonnes group = dao.findGroup(g);
		assertEquals("ISSL",	group.getName());
	}
	
}
