package fr.univ.annuaire.test.svg;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.svg.DaoException;
import fr.univ.annuaire.svg.JdbcTools;
import fr.univ.annuaire.svg.IResultSetToBean;


public class JdbcToolsTest extends JdbcTools {

	static JdbcTools newTool;

	
	@BeforeClass
	public static void initialisation() throws ClassNotFoundException{
		newTool = new JdbcTools();
		
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
		assertEquals("com.mysql.jdbc.Driver", newTool.getDriver()); //TODO meilleur façon de recup les driver FAIRE UN FICHIER DE CONFIG
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
		newTool.executeUpdate(query);
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
		
		newTool.executeUpdate(query, email, website, birthdate.toString(), idgroup, id, firstname);
	}
	
	
	@Test(timeout = 2000)
	public void insertPrepared() throws SQLException, ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
		Date date = simpleDateFormat.parse("31-01-2010");
		
		String query = 	"INSERT INTO personnes(lastname, firstname, email, website, birthdate, idgroup, id, passWord)"+
						"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String lastname = "magron";
		String password = "";
		String firstname = "claude";
		String email = "test.test@gmail.com";
		String website = "testdusiteinternet.com";
		Date birthdate = date;
		int idgroup = 5;
		int id = 18;

		newTool.executeUpdate(query, lastname, firstname, email, website, birthdate.toString(), idgroup, id, password);
	}
	
	
	@Test(timeout = 2000)
	public void deletePrepared() throws SQLException {
		String query = 	"DELETE FROM Personnes WHERE lastname = ? AND firstname = ?";
		String prenom = "magron";
		String nom = "claude";
		newTool.executeUpdate(query, nom, prenom);
	}
	

//	@Test (timeout = 2000)
//	public void findBeans() throws DaoException{
//		String query = "SELECT id, lastname, firstname, email, website, birthdate, idgroup, passWord FROM Personnes";
//		IResultSetToBean<Personne> mapper = new Personne();
//		Collection<Personne> person = newTool.findBeans(query, mapper);
//		System.out.println(person);
//	}
	
	
}
