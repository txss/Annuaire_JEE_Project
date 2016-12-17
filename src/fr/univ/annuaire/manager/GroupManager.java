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
	
	
	public Dao getDao() {
		return dao;
	}
	public void setDao(Dao dao) {
		this.dao = dao;
	}


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
		Collection<GroupPersonnes> grPersons = dao.findAllGroups();
		return grPersons.size() != 0 ? grPersons : null;
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
	
	
	/**
	 * This methode save a group of personne in database
	 * If the group already exist in the database the group is not added
	 * @param gr groupPersonnes to save
	 */
	public void saveGroup(GroupPersonnes gr){
		try {
			dao.findGroupByName(gr.getName());
		} catch (DaoException e) {
			String id = gr.getName().toLowerCase().replace(" ", "-");
			gr.setId(id);
			try {
				dao.saveGroup(gr);
			} catch (DaoException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Explicit methode name
	 * This methode delete a groupe in database
	 * @param gr the group to delete
	 */
	public void deleteGroup(GroupPersonnes gr){
		dao.deleteGroup(gr);
	}
	
}
