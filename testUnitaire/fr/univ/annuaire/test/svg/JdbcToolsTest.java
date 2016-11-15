package fr.univ.annuaire.test.svg;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univ.annuaire.svg.JdbcTools;

public class JdbcToolsTest extends JdbcTools {

	private static JdbcTools newTool;
	
	@BeforeClass
	public static void initialisation() throws ClassNotFoundException, SQLException{
		newTool = new JdbcTools();
		
		newTool.setDriver(JdbcTools.MYSQL_DRIVER);
		newTool.setUrl("jdbc:mysql://localhost/annuaire");
		newTool.setUser("admin");
		newTool.setPassword("admin");
		newTool.init();
		
	}
	
	@AfterClass
	public static void closing(){
		newTool.close();
	}
	
	@Test(timeout = 2000)
	public void testConnection() throws SQLException{
		newTool.newConnection();
	}
	
	@Test(timeout = 2000)
	public void init() throws ClassNotFoundException{
		newTool.init();
	}
	
	
//	@Test
//	public void closeOK() {
//		newTool.close();
//	}
	
	
	@Test(timeout = 2000)
	public void getURLTest(){
		assertEquals("jdbc:mysql://localhost/annuaire", newTool.getUrl());
	}
	
	@Test(timeout = 2000)
	public void getDriverTest(){
		assertEquals("com.mysql.jdbc.Driver", newTool.getDriver()); //TODO meilleur fa�on de recup les driver FAIRE UN FICHIER DE CONFIG
	}
	
	@Test(timeout = 2000)
	public void getUserTest(){
		assertEquals("admin", newTool.getUser());
	}

	@Test(timeout = 2000)
	public void getPasswordTest(){
		assertEquals("admin", newTool.getPassword());
	}
	
	@Test(timeout = 2000)
	public void setDriverTest(){
		newTool.setDriver("test.driver.new");
		assertEquals("test.driver.new", newTool.getDriver());
	}
	
	@Test(timeout = 2000)
	public void selectSimple() throws SQLException {
		String query = "SELECT id, lastname, firstname, email, website, birthdate, idgroup FROM Personnes";

		assertNotNull(newTool.executeUpdate(query));
	}
	
	
	@Test(timeout = 2000)
	public void updatePrepared() throws SQLException, ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
		Date date = simpleDateFormat.parse("31-01-2010");
		
		String query = 	"UPDATE Personnes SET email = ?, website = ?, birthdate = ?, idgroup = ? WHERE id = ? AND firstname = ?";
		String email = "test.test@gmail.com";
		String website = "testdusoteinternet.com";
		Date birthdate = date;
		int idgroup = 5;
		String firstname = "marron";
		int id = 0;

		assertNull(newTool.executeUpdate(query, email, website, birthdate.toString(), idgroup, id, firstname));
	}
	
	
	@Test(timeout = 2000)
	public void insertPrepared() throws SQLException, ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
		Date date = simpleDateFormat.parse("31-01-2010");
		
		String query = 	"INSERT INTO personnes(lastname, firstname, email, website, birthdate, idgroup, passWord)"+
						"VALUES (?, ?, ?, ?, ?, ?, ?)";
		String lastname = "magron";
		String password = "";
		String firstname = "claude";
		String email = "test.test@gmail.com";
		String website = "testdusiteinternet.com";
		Date birthdate = date;
		int idgroup = 5;

		assertNull(newTool.executeUpdate(query, lastname, firstname, email, website, birthdate.toString(), idgroup, password) );
	}
	
	
	@Test(timeout = 2000)
	public void deletePrepared() throws SQLException {
		String query = 	"DELETE FROM Personnes WHERE lastname = ? AND firstname = ?";
		String prenom = "magron";
		String nom = "claude";
		assertNull(newTool.executeUpdate(query, nom, prenom));
	}
	
	
	@Test(timeout = 2000)
	public void selectSimpleOnTableGroupes() throws SQLException {
		String query = "SELECT id, name FROM groupes_personnes";
		assertNotNull(newTool.executeUpdate(query));
	}
	
	
	@Test(timeout = 2000)
	public void insertPreparedOnTableGroupes() throws SQLException, ParseException {
		String query = 	"INSERT INTO groupes_personnes(name)"+
						"VALUES (?)";
		String name = "ISL";

		assertNull(newTool.executeUpdate(query, name));
	}
	
	
}
