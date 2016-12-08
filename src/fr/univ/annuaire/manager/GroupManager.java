/**
 * Regroup all methodes to link the dao part and the controller part
 * Every methode to access data in data base for a user request about groups need to be implement in this Class
 * @author Campanella & Magron
 */
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
	
	
	/**
	 * Explicite name..
	 * return all groups contain in the database
	 * @return a Collection<GroupPersonnes> with all person in the database
	 */
	public Collection<GroupPersonnes> getAllGroups(){
		Collection<GroupPersonnes> persons = dao.findAllGroups();
		return persons;
	}
	
	
	/**
	 * Find one group in the database with the groupe ID
	 * @param groupID id group to find
	 * @return if the id group match with a group in database return the group else return null
	 */
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
