package fr.univ.annuaire.test.jdbcTools;

import java.sql.SQLException;
import java.util.Collection;

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
		
		newTool.setUrl("jdbc:mysql://localhost/personnes");
		newTool.setUser("root");
		newTool.setPassword("admin");
		newTool.init();
	}
	
	@AfterClass
	public static void closing(){
		newTool.close();
	}
	
	@Test
	public void testConnection() throws SQLException{
		newTool.newConnection();
	}
	
//	@Test
//	public void init() throws ClassNotFoundException{
//		newTool.init();
//	}
	
	
//	@Test
//	public void closeOK() {
//		newTool.close();
//	}
	
	// TODO refactor this code 
	
	@Test
	public void selectSimple() throws SQLException {
		String query = "SELECT Nom, Prenom, Age FROM Personne";
		newTool.executeUpdate(query);
	}
	
	
	@Test(timeout = 2000)
	public void updatePrepared() throws SQLException {
		String query = 	"UPDATE Personne SET Age = ? WHERE Nom = ? AND Prenom = ?";
		String prenom = "marron";
		String nom = "luc";
		int age = 2;
		newTool.executeUpdate(query, age, nom, prenom);
	}
	
	
	@Test(timeout = 2000)
	public void insertPrepared() throws SQLException {
		String query = 	"INSERT INTO personne(Nom, Prenom, Age)"+
						"VALUES (?, ?, ?)";
		String prenom = "magron";
		String nom = "massat";
		int age = 45;
		newTool.executeUpdate(query, nom, prenom, age);
	}
	
	
	@Test(timeout = 2000)
	public void deletePrepared() throws SQLException {
		String query = 	"DELETE FROM Personne WHERE Nom = ? AND Prenom = ?";
		String prenom = "magron";
		String nom = "massat";
		newTool.executeUpdate(query, nom, prenom);
	}
	

	@Test (timeout = 2000)
	public void findBeans() throws DaoException{
		String query = "SELECT id, Nom, Prenom, Age FROM Personne";
		IResultSetToBean<Personne> mapper = new Personne();
		Collection<Personne> person = newTool.findBeans(query, mapper);
		System.out.println(person);
	}
	
	
}
