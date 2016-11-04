package fr.univ.annuaire.beans;

import java.util.ArrayList;

public class GroupPersonnes {

	private int id;
	private String name;
	private ArrayList<Personne> personneInGroup;
	
	
	/**
	 * Default constructor
	 */
	public void GroupPersonnes() { }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Personne> getPersonneInGroup() {
		return personneInGroup;
	}
	
	public void setPersonneInGroup(ArrayList<Personne> personneInGroup) {
		this.personneInGroup = personneInGroup;
	}
	
}
