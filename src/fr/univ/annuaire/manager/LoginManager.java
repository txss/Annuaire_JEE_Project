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
	
}
