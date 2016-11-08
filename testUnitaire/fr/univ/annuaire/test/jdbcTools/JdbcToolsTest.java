package fr.univ.annuaire.test.jdbcTools;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import fr.univ.annuaire.svg.JdbcTools;

public class JdbcToolsTest extends JdbcTools {

	JdbcTools newTool;
	
	@Before
	public void before (){
		newTool = new JdbcTools();
		
		newTool.setDriver("com.mysql.jdbc.Driver");
		newTool.setUrl("jdbc:mysql://dbs-perso.luminy.univmed.fr/c12019804");
		newTool.setUser("c12019804");
		newTool.setPassword("WCXFT?");
	}
	
	
	@Test (timeout = 2000)
	public void initOK() throws ClassNotFoundException{
		newTool.init();
	}
	
	@Test (timeout = 2000)
	public void connect () throws SQLException, ClassNotFoundException{
		newTool.newConnection();
	}
	
	@Test
	public void request() throws SQLException {
		newTool.executeUpdate("SELECT nom, prenom, age FROM Personne");
	}

	@Test
	public void closeOK() {
		newTool.close();
	}

}
