package fr.univ.annuaire.svg;

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
	 */
	Personne findPerson(long id);


	/**
	 * Methode to save or update a personne in the person book
	 * @param p
	 */
	void savePerson(Personne personne);


	/**
	 *  Methode for delete a person in the person book
	 *  (the person will be delete to in the all group)
	 * @param personne
	 */
	void deletePerson(Personne personne);

}
