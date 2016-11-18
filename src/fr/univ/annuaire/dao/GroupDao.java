package fr.univ.annuaire.dao;

import java.util.Collection;

import fr.univ.annuaire.beans.GroupPersonnes;

public interface GroupDao {

	/**
	 * Methode to get all group in the database
	 * @return a collection of all group in the person book
	 */
	Collection<GroupPersonnes> findAllGroups();

	
	/**
	 * add a group
	 * @param group to update
	 * @throws DaoException if the group alerady exist in the database
	 */
	void saveGroup(GroupPersonnes group) throws DaoException;
	
	
	/**
	 * This methode update values of a group and save it in the database
	 * @param group to update
	 */
	void UpdateGroup(GroupPersonnes group);
	
	
	/**
	 * Delete a group in database
	 * @param group to delete
	 */
	void deleteGroup(GroupPersonnes group);
	
	
	/**
	 * This methode return a colleectio of groups if the groups name passed in param match the groupes in
	 * database 
	 * @param groups to find in database 
	 * @return
	 * @throws DaoException 
	 */
	GroupPersonnes findGroupByName(String groupName) throws DaoException;


	/**
	 * This methode find a group in database by ID
	 * @param group
	 * @return the group if it exist
	 * @throws DaoException if the Group doesn't exist in datbase
	 */
	GroupPersonnes findGroup(GroupPersonnes group) throws DaoException;
	
}
