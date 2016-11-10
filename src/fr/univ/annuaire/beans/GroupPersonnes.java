package fr.univ.annuaire.beans;

import java.util.ArrayList;

public class GroupPersonnes{

	private int id;
	private String name;
	private ArrayList<Personne> personneInGroup;
	
	
	/**
	 * Default constructor
	 */
	public GroupPersonnes() { }
	
	
	// BEGIN getter and setter
	
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
	
	// END getter and setter
	
	public String toString (){
		return "id: " + this.id + "\nnom: " + this.name;
	}
	
	
//	@Override
//	public GroupPersonnes toBean(ResultSet rs) throws SQLException {
//		
//		while (rs.next()) {
//			this.setId(rs.getInt(1) );
//			this.setName(rs.getString(2) );
////			this.setFirstName(rs.getString(3) );
//        }
//		
//		return this;
//	}
	
}
