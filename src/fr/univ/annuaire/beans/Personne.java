package fr.univ.annuaire.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Personne {
	
	private int id;
	
	@NotNull
    @Size(min = 2, max = 60, message = "Le nom est obligatoire (min 2, max 60)")
	private String firstName;
	
	@NotNull
    @Size(min = 2, max = 60, message = "Le prènom est obligatoire (min 2, max 60)")
	private String lastName;
	
	@NotNull
	@Size(min = 10, max = 10, message = "La date de naissance est obligatoire, format YYYY-MM-DD")
	private String birthDate;
	
	@NotNull
    @Size(min = 6, max = 50, message = "Votre email est obligatoire")
	private String email;
	
	private String webSite;
	
	@NotNull
	@Size(min = 3, message = "Le groupe est obligatoire")
	private String idGroup;
	
	@NotNull
    @Size(min = 4, message = "Le mot de passe est obligatoire")
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
	
	public String getIdGroup() {
		return idGroup;
	}
	
	public void setBirthDate(String birthday) {
		this.birthDate = birthday;
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
	
	public void setIdGroup(String idGroup){
		this.idGroup = idGroup;
	}
	// END Getters and Setters
	

	public String toString(){
		return "\n"+"id: " + this.id + "\nprenom: " + this.firstName + "\nnom: " + this.lastName + "\nemail: " + this.email + "\nwebSite: " + this.webSite + "\nGroupe: " + this.idGroup;
	}
	
	
	/**
	 * This methode test if the properties value of two Personne are identical
	 * @param personne the personne to test
	 * @return true if the two personnes are identical, false if they are not.
	 */
	public boolean isEquals(Personne personne){
		if(this.id != personne.getId())
			return false;
		if(!this.firstName.equals(personne.getFirstName()))
			return false;
		if(!this.lastName.equals(personne.getLastName()))
			return false;
		if(!this.birthDate.equals(personne.getBirthDate()))
			return false;
		if(!this.email.equals(personne.getEmail()))
			return false;
		if(!this.webSite.equals(personne.getWebSite()))
			return false;
		if(!this.idGroup.equals(personne.getIdGroup()))
			return false;
		if(!this.passWord.equals(personne.getPassWord()))
			return false;
		return true;
	}
	
}
