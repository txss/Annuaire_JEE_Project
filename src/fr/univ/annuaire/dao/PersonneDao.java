package fr.univ.annuaire.dao;

import java.util.Collection;

import fr.univ.annuaire.beans.Personne;

public interface PersonneDao {

	/**
	 * Methode to get all person in the person book
	 * @return all person in the person book
	 */
	Collection<Personne> findAllPersons();
	
	
	/**
	 * Methode to get all person in one group
	 * @param groupId the group we want the person
	 * @return A collection of beans "personne" in the group you asked
	 */
	Collection<Personne> findAllPersonsInGroup(long groupId);
	
	
	/**
	 *  Methode to get one person in the person book
	 * @param id person to find
	 * @return A Personne bean with the id you give in param 
	 * @throws DaoException 
	 */
	Personne findPersonByID(long id) throws DaoException;


	/**
	 * Methode to save a new personne in the person book
	 * the id of the person will be autoincrements by database
	 * @param p
	 */
	void insertPerson(Personne personne) throws DaoException;


	/**
	 * Methode to update a personne in the person book
	 * the person will be identify by it's id
	 * @param personne
	 */
	void updatePerson(Personne personne);
	
	
	/**
	 *  Methode for delete a person in the person book
	 *  (the person will be delete to in the all group)
	 * @param personne
	 */
	void deletePerson(Personne personne);

	
	/**
	 * This methode is util to excute the search
	 * @param search the value in datbase
	 * @return a collection of person who match with the search
	 */
	Collection<Personne> searchKeywordInPersons(String search);
}
