package fr.univ.annuaire.test.svg;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.univ.annuaire.svg.JdbcTools;

public class JdbcToolsPGTestHC {

	private static JdbcTools newTool;
	
	@BeforeClass
	public static void initialization() throws ClassNotFoundException{
		newTool = new JdbcTools();
	}//initialization()
	
	
	@Test(timeout = 2000)
	public void getURLTest(){
		newTool.setUrl("urltest");
		String url = newTool.getUrl();
		assertEquals("urltest", url);
	}//getUrlTest()

	@Test(timeout = 2000)
	public void getUserTest(){
		newTool.setUser("users");
		String user = newTool.getUser();
		assertEquals("users", user);
	}//getUserTest()
	
	@Test(timeout = 2000)
	public void getPwdTest(){
		newTool.setPassword("password");
		String pwd = newTool.getPassword();
		assertEquals("password", pwd);
	}//getPwdTest()
	
	@Test(timeout = 2000, expected = SQLException.class)
	public void selectSimpleOnTableGroupesErr() throws SQLException {
		String query = "SELECT id_group, name_group FROM \"GROUPE\"";
		newTool.executeUpdate(query);
	}//selectSimpleOnTableGroupes()
}
