package fr.univ.annuaire.svg;

import java.util.Collection;

import fr.univ.annuaire.beans.GroupPersonnes;

public interface GroupDao {

	/**
	 * Methode to get all person group
	 * @return a collection of all group in the person book
	 */
	Collection<GroupPersonnes> findAllGroups();

	
	/**
	 * add or update a person group
	 * @param group
	 */
	void saveGroup(GroupPersonnes group);
	
	
	/**
	 * Delete a person group
	 * @param group
	 */
	void deleteGroupByID(GroupPersonnes group);
	
	
}
