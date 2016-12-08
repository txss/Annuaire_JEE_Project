package fr.univ.annuaire.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@Service
public class GroupManager {

	@Autowired
	Dao dao;
	
	
	/**
	 * Default construcor
	 */
	public GroupManager(){}
	
	
	public Collection<GroupPersonnes> getGroupList(){
		Collection<GroupPersonnes> persons = dao.findAllGroups();
		return persons;
	}
	
	
	public GroupPersonnes findGroup(String groupID){
		GroupPersonnes group = new GroupPersonnes();
		group.setId(groupID);
		
		try {
			return dao.findGroup(group);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
