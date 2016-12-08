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
	public void save(Personne pers){ //TODO exiger le mdp pour update les données
		dao.updatePerson(pers);
	}
	
}
