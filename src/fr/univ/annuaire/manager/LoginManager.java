/**
 * Regroup all methodes to link the dao part and the controller part 
 * Every methode to access data in data base for a user request about the login need to be implement in this Class
 * @author Campanella & Magron
 */
package fr.univ.annuaire.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.annuaire.beans.Login;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@Service
public class LoginManager {

	@Autowired
	Dao dao;
	
	
	
	public Dao getDao() {
		return dao;
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}


	/**
	 * default constructor
	 */
	public LoginManager() {}
	

	/**
	 * Correct login checker.
	 * This methode get data submit by the user and verify if that match with a user contain in the database
	 * @param login the bean Login to compare with the person in database
	 * @return return the Annuaire user or null if he doesn't exist
	 * @throws DaoException this exception means the person doesn't exist in database
	 * this exception must be catch and print in server log by the calling methode
	 */
	public Personne checkLogin(Login login){
		Personne p;
		try {
			p = dao.findPersonByEmail(login.getEmail());
		} catch (Exception e) {
			return null;
		}

		if(p.getEmail().equals(login.getEmail()))
			if(p.getPassWord() != null)
				if(p.getPassWord().equals(login.getPassWord()))
					return p;
		
		return null;
	}
	
	/**
	 * This methode search a person in the database by the email
	 * @param email
	 * @return
	 */
	public Personne getPerson(String email){
		try {
			return dao.findPersonByEmail(email);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * This methode check in database if the person pers is in already in base by the email
	 * Then if the email doesn't exist, save the person in the database.
	 * @param pers the bean to save in database
	 * @return boolean true if the person was save successfully, otherwise false
	 */
	public boolean saveNewPerson(Personne pers){
		try {
			dao.findPersonByEmail(pers.getEmail());
		} catch (Exception e) {
			dao.insertPerson(pers);
			return true;
		}
		return false;
	}
	
}
