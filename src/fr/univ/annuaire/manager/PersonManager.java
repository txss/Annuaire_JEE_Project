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
	
	
	public Collection<Personne> getPersonList(){
		Collection<Personne> persons = dao.findAllPersons();
		return persons;
	}
	
	
	public Personne getPerson(long id){
		try {
			return dao.findPersonByID(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<Personne> findAllPersonInGroup(String groupID){
		return dao.findAllPersonsInGroup(groupID);
	}
}
