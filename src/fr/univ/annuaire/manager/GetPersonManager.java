package fr.univ.annuaire.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;

@Service
public class GetPersonManager {

	@Autowired
	Dao dao;
	
	
	/**
	 * default constructor
	 */
	public GetPersonManager() {}
	
	
	public Collection<Personne> getPersonList(){
		Collection<Personne> persons = dao.findAllPersons();
		return persons;
	}
	
}
