package fr.univ.annuaire.beans;

public class GroupPersonnes{

	private int id;
	private String name;
	
	
	/**
	 * Default constructor
	 */
	public GroupPersonnes() { }
	
	
	// BEGIN getter and setter
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	// END getter and setter
	
	public String toString (){
		return "\nid: " + this.id + " --> nom: " + this.name;
	}
	
}
