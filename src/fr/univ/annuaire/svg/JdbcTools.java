package fr.univ.annuaire.svg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcTools {

	private String driver;
	private String url;
	private String user;
	private String password;
	
	/**
	 * Contstructeur par defaut
	 */
	public JdbcTools () {}
	
	
	// BEGIN getter and setter
	
	public String getDriver() {
		return driver;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
	
	
	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// END getter and setter

	public void init() throws ClassNotFoundException {
		System.out.println("Initializing JDBCTOOLS...");
		loadDriver();
	}
	
	public void close(){
		System.out.println("Closing JDBCTOOLS...");
	}
	
	
	private void loadDriver() throws ClassNotFoundException {
	    Class.forName(driver);
	}
	
	
	public Connection newConnection() throws SQLException {
	    Connection conn = DriverManager.getConnection(url, user, password);
	    return conn;
	}
	
	public void quietClose(Connection c) throws SQLException {
		if (c != null) c.close();
	}
	
	
	public int executeUpdate(String query/*,Object... parameters*/) throws SQLException {
		Connection connect = null;
		int nb = 0;
		
		try {
			connect = newConnection();
			PreparedStatement st = connect.prepareStatement(
					"UPDATE personne SET Age = ? " +
				    "WHERE Nom = ? "
			);
			/*ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
	            System.out.printf("%-20s | %-20s | %3d\n", //
	                    rs.getString(1), rs.getString(2), rs.getInt(3));
	        }
			*/
			st.close();
		} finally {
			quietClose(connect);
		}
		
		return nb;
	}
	
}
