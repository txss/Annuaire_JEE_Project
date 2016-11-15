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
		return "id: " + this.id + "\nnom: " + this.name;
	}
	
	// TODO suppr this
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
