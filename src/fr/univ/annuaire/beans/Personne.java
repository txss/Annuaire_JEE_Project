package fr.univ.annuaire.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.univ.annuaire.svg.IResultSetToBean;

public class Personne implements IResultSetToBean<Personne>{
	
	private int id;
	private String passWord; // TODO crypt this password
	private String firstName;
	private String lastName;
	private String birthDate; // TODO type date
	private String email;
	private String webSite;
	
	
	
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
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
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
	// END Getters and Setters
	

	public String toString(){
		return "\n"+"id: " + this.id + " \n nom: " + this.lastName + "\n prenom: " + this.firstName + "\n email: " + this.email + "\n webSite: " + this.webSite;
	}

	@Override
	public Personne toBean(ResultSet rs) throws SQLException {
		
		while (rs.next()) {
			this.setId(rs.getInt(1) );
			this.setFirstName(rs.getString(2) );
			this.setFirstName(rs.getString(3) );
        }
		
		return this;
	}
}
