/**
 * Regroup all methodes to link the dao part and the controller part 
 * Every methode to access data in data base for a user request about the person in the database need to be implement in this Class
 * @author Campanella & Magron
 */
package fr.univ.annuaire.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@Service
public class PersonManager {

	@Autowired
	Dao dao;
	
	
	/**
	 * default constructor
	 */
	public PersonManager() {}
	
	
	/**
	 * This methode return all person store in database
	 * @return a Collection<Personne> store in the database
	 */
	public Collection<Personne> getAllPerson(){
		Collection<Personne> persons = dao.findAllPersons();
		return persons;
	}
	
	
	/**
	 * This methode search in database if a person with the id in param exist in database
	 * @param id of the person to search
	 * @return a Personne if exist in the database else return null
	 */
	public Personne getPerson(long id){
		try {
			return dao.findPersonByID(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Explixit name.
	 * This methode retrun all person with they are in the group that research
	 * @param groupID the id group research
	 * @return a Collection<Personne> of all person in the group
	 */
	public Collection<Personne> findAllPersonInGroup(String groupID){
		return dao.findAllPersonsInGroup(groupID);
	}
	
	
	/**
	 * This methode implement the search feature in the Annuaire application
	 * That search in database all persons and groups that match with the request
	 * That return a collection of personne.
	 * The search will be done by a simple search on lastName, firstName, website, of the person AND by search on the groupName of the group
	 * @param search word to search in the data
	 * @return a Collection<Personne>
	 */
	public Collection<Personne> searchPerson(String search){
		return dao.searchKeywordInPersons(search);
	}
	
	
	/**
	 * This methode check in database if the person pers is in already in base by the email
	 * Then if the email doesn't exist, save the person in the database.
	 * @param pers the bean to save in database
	 * @return boolean true if the person was save successfully, otherwise false
	 */
	public boolean saveNewPerson(Personne pers){
		// TODO 
		// check in base by email
		// if not present save and return true 
		return false;
	}
	
}
