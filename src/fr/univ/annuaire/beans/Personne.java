package fr.univ.annuaire.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import fr.univ.annuaire.svg.IResultSetToBean;

public class Personne implements IResultSetToBean<Personne>{
	
	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private String webSite;
	private int idGroup;
	private String passWord; // TODO crypt this password
	
	
	
	/**
	 * Default constructor
	 */
	public Personne(){
		
	}
	
	// BEGIN Getters and Setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public int getIdGroup() {
		return idGroup;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getWebSite() {
		return webSite;
	}
	
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	public void setIdGroup(int idGroup){
		this.idGroup = idGroup;
	}
	// END Getters and Setters
	

	public String toString(){
		return "\n"+"id: " + this.id + " \n nom: " + this.lastName + "\n prenom: " + this.firstName + "\n email: " + this.email + "\n webSite: " + this.webSite + "\n Groupe: " + this.idGroup;
	}

	@Override
	public Personne toBean(ResultSet rs) throws SQLException {

		while (rs.next()) {
			this.setId(rs.getInt(1) );
			this.setLastName(rs.getString(2) );
			this.setFirstName(rs.getString(3) );
			this.setEmail(rs.getString(4));
			this.setWebSite(rs.getString(5));
			this.setBirthDate(rs.getDate(6));
			this.setIdGroup(rs.getInt(7));
			this.setPassWord(rs.getString(8));
        }
		
		return this;
	}
}
