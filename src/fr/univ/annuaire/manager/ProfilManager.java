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
	
	
	public void save(Personne pers){
		dao.updatePerson(pers);
	}
	
}
