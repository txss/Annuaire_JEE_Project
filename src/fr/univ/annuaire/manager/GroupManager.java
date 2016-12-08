package fr.univ.annuaire.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.dao.Dao;

@Service
public class GetGroupManager {

	@Autowired
	Dao dao;
	
	
	/**
	 * Default construcor
	 */
	public GetGroupManager(){}
	
	
	public Collection<GroupPersonnes> getGroupList(){
		Collection<GroupPersonnes> persons = dao.findAllGroups();
		return persons;
	}
}
