package fr.univ.annuaire.test.dao;


import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;
import fr.univ.annuaire.svg.JdbcTools;

public class DaoGroupeErrorTest {
	
	Dao dao;
	
	@Before
	public void before () throws ClassNotFoundException{
		dao = new Dao();
		
		dao.setDriver(JdbcTools.POSTGRESQL_DRIVER);
		dao.setUrl("jdbc:postgresql://vulgamatiqu");
		dao.setUser("");
		dao.setPassword("!");
	}

	@Test (timeout = 2000, expected =SQLException.class)
	public void findAllGroupsErr() {
		dao.findAllGroups();
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void deleteGroupByIDErr() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("M2FSIL2018");
		dao.deleteGroup(g);
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void findGroup() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("M2FSIL2016");
		dao.findGroup(g);
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void findGroupByNameErr() throws DaoException{
		dao.findGroupByName("M2 FSIL 2015/2016");
	}
	
	@Test (timeout = 2000, expected = SQLException.class)
	public void UpdateGroupByIDErr() throws DaoException{
		GroupPersonnes g = new GroupPersonnes();
		g.setId("777");
		g.setName("ISSL");
		dao.UpdateGroup(g);
	}
	
	
}
