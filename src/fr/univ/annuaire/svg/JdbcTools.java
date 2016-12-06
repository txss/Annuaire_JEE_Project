package fr.univ.annuaire.svg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class JdbcTools {
	protected final Log logger = LogFactory.getLog(getClass());
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

	@PostConstruct
	public void init() throws ClassNotFoundException {
		logger.info( (new Date()).toString() + " Initializing JdbcTools...");
		loadDriver();
	}
	
	public void close(){
		logger.info("Close JdbcTools...");
	}
	
	/**
	 * Use this methode to load the database driver
	 * @throws ClassNotFoundException
	 */
	private void loadDriver() throws ClassNotFoundException {
	    if(driver != null)
	    	Class.forName(driver);
	}
	
	
	/**
	 * This methode create and return a new connection with the class attributes values
	 * @return a available connection to the database
	 * @throws SQLException
	 */
	public Connection newConnection() throws SQLException {
		logger.info((new Date()).toString() + " Create new connection on database.");
	    Connection conn = DriverManager.getConnection(url, user, password);
	    return conn;
	}

	
	/**
	 * This methode is used to exectute a database a prepared statement request
	 * @param query you SQL request
	 * @param parameters the value of prameter in your prepared statment
	 * @return a resultSet, null if the rs is empty
	 * @throws SQLException
	 */
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
