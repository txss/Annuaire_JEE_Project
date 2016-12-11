/**
 * Regroup all methodes to link the dao part and the controller part 
 * Every methode to access data in data base for a user request about one specific(current user) person in the database need to be implement in this Class
 * @author Campanella & Magron
 */
package fr.univ.annuaire.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@Service
public class ProfilManager {

	@Autowired
	Dao dao;
	
	
	/**
	 * Default constructor
	 */
	public ProfilManager(){}
	
	
	/**
	 * This methode save the update done by the current user on it's own data except the password.
	 * @param pers the person to save
	 */
	public boolean save(Personne pers){
		Personne p;
		try {
			p = dao.findPersonByID(pers.getId());
		} catch (DaoException e) {
			e.printStackTrace();
			return false;
		}
		
		if (p.getPassWord().equals(pers.getPassWord())){
			dao.updatePerson(pers);
			return true;
		}
		return false;
	}
	
	
	public boolean validatePerson(Personne pers){
		return false;
	}
	
}
