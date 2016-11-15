package fr.univ.annuaire.beans;

import java.util.Date;

public class Personne {
	
	private int id;
	private String firstName;
	private String lastName;
	private String birthDate;
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
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public int getIdGroup() {
		return idGroup;
	}
	
	public void setBirthDate(String string) {
		this.birthDate = string;
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
		return "\n"+"id: " + this.id + "\nprenom: " + this.firstName + "\nnom: " + this.lastName + "\nemail: " + this.email + "\nwebSite: " + this.webSite + "\nGroupe: " + this.idGroup;
	}

}
