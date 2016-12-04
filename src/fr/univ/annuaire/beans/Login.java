package fr.univ.annuaire.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {

	@NotNull
    @Size(min = 6, message = "Votre email est obligatoire (min 6 caractéres)")
	private String email;
	
	@NotNull
    @Size(min = 4, message = "Le mot de passe est obligatoire (min 4 caractéres)")
	private String passWord;// TODO crypt this password
	
	
	/**
	 * Default constructor of pojo login
	 */
	public Login(){}
	
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
