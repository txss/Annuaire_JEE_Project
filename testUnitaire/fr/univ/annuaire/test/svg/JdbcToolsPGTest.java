package fr.univ.annuaire.test.svg;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univ.annuaire.svg.JdbcTools;

public class JdbcToolsPGTest {

	private static JdbcTools newTool;
	
	private Calendar initAndGetCalendar(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1); // <-- months start
		                                    // at 0.
		cal.set(Calendar.DAY_OF_MONTH, day);
		
		return cal;
	}//initAndGetCalendar()

	@BeforeClass
	public static void initialization() throws ClassNotFoundException{
		newTool = new JdbcTools();

		newTool.setDriver(JdbcTools.POSTGRESQL_DRIVER);

		newTool.init();
	}//initialization()

	@AfterClass
	public static void closing(){
		newTool.close();
	}//closing()

	@Test(timeout = 2000)
	public void testConnection() throws SQLException{
		newTool.newConnection();
	}//testConnection()

	@Test(timeout = 2000)
	public void init() throws ClassNotFoundException{
		newTool.init();
	}//init()


	//	@Test
	//	public void closeOK() {
	//		newTool.close();
	//	}




	@Test(timeout = 2000)
	public void setDriverTest(){
		newTool.setDriver("test.driver.new");
		assertEquals("test.driver.new", newTool.getDriver());
	}//setDriverTest()

	@Test(timeout = 2000)
	public void selectSimple() throws SQLException {
		String query = "SELECT id_person, firstname_person, lastname_person, "
				+ "email_person, web_person, birthday_person, id_group FROM \"PERSONNE\"";
		newTool.executeUpdate(query);
	}//selectSimple()
	
	@Test(timeout = 2000)
	public void insertPrepared() throws SQLException {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
		
		String query = 	"INSERT INTO \"PERSONNE\" (id_person, lastname_person, firstname_person, email_person, web_person, birthday_person, passwd_person, id_group)"+
				"VALUES (nextval('\"Personne_id_person_seq\"'), ?, ?, ?, ?, ?, ?, ?)";
		String firstname = "Benjamin";
		String lastname = "Magron";
		String email = "test.test@gmail.com";
		String website = "testdusiteinternet.com";
		String password = "josef";
		Date birthday = new Date(initAndGetCalendar(22, 2, 1993).getTimeInMillis());
		String idgroup = "M2FSIL2016";

		newTool.executeUpdate(query, lastname, firstname, email, website, birthday, password, idgroup);
	}//insertPrepared()

	
	@Test(timeout = 2000)
	public void updatePrepared() throws SQLException {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);

		String query = 	"UPDATE \"PERSONNE\" SET email_person = ?, web_person = ?, birthday_person = ? WHERE lastname_person = ?";
		String email = "test.test@gmail.com";
		String website = "testdusiteinternet.com";
		Date birthday = new Date(initAndGetCalendar(27, 10, 1991).getTimeInMillis());
		String lastname = "Cohen";

		newTool.executeUpdate(query, email, website, birthday, lastname);
	}//updatePrepared()


	@Test(timeout = 2000)
	public void deletePrepared() throws SQLException {
		String query = 	"DELETE FROM \"PERSONNE\" WHERE lastname_person = ?";
		String prenom = "Magron";
		newTool.executeUpdate(query, prenom);
	}//deletePrepared()


	//	@Test (timeout = 2000)
	//	public void findBeans() throws DaoException{
	//		String query = "SELECT id, lastname, firstname, email, website, birthdate, idgroup, passWord FROM Personnes";
	//		IResultSetToBean<Personne> mapper = new Personne();
	//		Collection<Personne> person = newTool.findBeans(query, mapper);
	//		System.out.println(person);
	//	}
}
