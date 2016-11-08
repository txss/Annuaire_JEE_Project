package fr.univ.annuaire.svg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;



public class JdbcTools {

	private String driver = "com.mysql.jdbc.Driver";
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

	// TODO CODE MORT????
	public void quietClose(Connection c) throws SQLException {
		if (c != null) c.close();
	}
	
	
	public int executeUpdate(String query, Object... parameters) throws SQLException {
		int nb = 0;
		
		try(Connection connect = newConnection();) {
//			Statement st = connect.createStatement();
//			ResultSet rs = st.executeQuery();
//			while (rs.next()) {
//	            System.out.printf("%-20s | %-20s | %3d\n", //
//	                    rs.getString(1), rs.getString(2), rs.getInt(3));
//	        }
		
			PreparedStatement st = connect.prepareStatement(query);

			for(int i = 0; i < parameters.length; i++) {
				
				if (parameters[i] instanceof Integer)
					st.setInt(i+1, (int) parameters[i]);
				
				if (parameters[i] instanceof java.sql.Date) // TODO DATE
					st.setDate(i+1, (java.sql.Date) parameters[i]);
				
				if (parameters[i] instanceof String)
					st.setString(i+1, (String) parameters[i]);
				
				if (parameters[i] instanceof Boolean)
					st.setBoolean(i+1, (Boolean) parameters[i]);
			}
			st.execute();			
			st.close();
		}
		
		return nb;
	}
	
	
	public <T> Collection<T> findBeans(String sql, IResultSetToBean<T> mapper) throws DaoException {
		Collection <T> beans = new ArrayList<T>();
		
		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			beans.add(mapper.toBean(rs));
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return beans;
	}//findBeans
	
}
