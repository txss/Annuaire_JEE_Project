package fr.univ.annuaire.test.dao;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class DaoGroupesTest {

	@Autowired
	Dao dao;

	@Test (timeout = 2000)
	public void findAllGroups() {
		Collection<GroupPersonnes> groupPersonnes = dao.findAllGroups();
		assertNotNull(groupPersonnes);
		System.out.println(groupPersonnes);
	}


	@Test (timeout = 2000)
	public void findGroup() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("default");

		GroupPersonnes res = dao.findGroup(g);
		assertEquals(g.getId(), res.getId());
	}


	@Test (timeout = 2000, expected = DaoException.class)
	public void findGroupByIDAbsent() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("existpas");
		dao.findGroup(g);
	}


	@Test (timeout = 2000)
	public void findGroupByName() throws DaoException{
		GroupPersonnes g = dao.findGroupByName("M2 ID 2015/2016");
		assertEquals("M2 ID 2015/2016", g.getName());
	}


	@Test (timeout = 2000, expected = DaoException.class)
	public void findGroupByNameAbsent() throws DaoException{
		dao.findGroupByName("Absent");
	}


	@Test (timeout = 2000, expected = DaoException.class)
	public void deleteGroupByID() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("test");

		dao.deleteGroup(g);
		dao.findGroup(g);
	}


	@Test (timeout = 2000)
	public void saveGroup() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("test");
		g.setName("TEST");

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
		g.setId("isl");
		g.setName("ISSL");

		dao.UpdateGroup(g);

		GroupPersonnes group = dao.findGroup(g);
		assertEquals("ISSL",	group.getName());
	}

}
