package fr.univ.annuaire.svg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class JdbcTools {
	public static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
	public final String MYSQL_DRIVER = "com.mysql.jdbc.Driver"; // TODO fichier de config

	private String driver;
	private String url;
	private String user;
	private String password;
	
	
	/** 
	 * Contstructeur par defaut
	 */
	public JdbcTools () {}
	
	
	// BEGIN getters and setters
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

	// END getters and setters


	public void init() throws ClassNotFoundException {
		System.out.println("Initializing JDBCTOOLS..."); // TODO
		loadDriver();
	}
	
	public void close(){
		System.out.println("Closing JDBCTOOLS..."); // TODO
	}
	
	private void loadDriver() throws ClassNotFoundException {
	    Class.forName(driver);
	}
	
	
	public Connection newConnection() throws SQLException {
	    Connection conn = DriverManager.getConnection(url, user, password);
	    return conn;
	}

	
	public ResultSet executeUpdate(String query, Object... parameters) throws SQLException {
		boolean ok = false;
		ResultSet rs = null;
		
		try(Connection connect = newConnection();) {
		
			PreparedStatement st = connect.prepareStatement(query);
			
			for(int i = 0; i < parameters.length; i++) {
				
				if (parameters[i] instanceof Integer)
					st.setInt(i+1, (int) parameters[i]);
				
				if (parameters[i] instanceof Date)
					st.setDate(i+1, (java.sql.Date) parameters[i]);
				
				if (parameters[i] instanceof String)
					st.setString(i+1, (String) parameters[i]);
			}
			ok = st.execute();
			if (ok)
				rs = st.getResultSet();
			st.close();
		}
		return rs;
	}
	
	
//	// TODO check this
//	public <T> Collection<T> findBeans(String sql, IResultSetToBean<T> mapper) throws DaoException {
//		Collection <T> beans = new ArrayList<T>();
//		
//		try(Connection connect = newConnection();) {
//			PreparedStatement st = connect.prepareStatement(sql);
//			ResultSet rs = st.executeQuery();
//			
//			beans.add(mapper.toBean(rs));
//			
//			st.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return beans;
//	}//findBeans
	
}
