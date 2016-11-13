package fr.univ.annuaire.svg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.beans.Personne;


public class Dao extends JdbcTools implements GroupDao {
	
	
	
	
	public Collection<Personne> findPersons() throws DaoException {
		Collection <Personne> personnes = new ArrayList<Personne>();
		
		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id, Nom, Prenom, Age FROM Personne");
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Personne p = new Personne();
//				p.toBean(rs);
				personnes.add(p);
	        }
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personnes;
	}//findPerson()
	
	
	
	
	public void bidon(){
//		IResultSetToBean<Personne> per = new IResultSetToBean<Personne>() {
//			
//			@Override
//			public Personne toBean(ResultSet rs) throws SQLException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		}; 
		
		IResultSetToBean<Personne> personne = (ResultSet rs)->{
			Personne p = new Personne();
			
			p.setId(rs.getInt(1) );
			p.setLastName(rs.getString(2) );
			p.setFirstName(rs.getString(3) );
			p.setEmail(rs.getString(4));
			p.setWebSite(rs.getString(5));
			p.setBirthDate(rs.getDate(6));
			p.setIdGroup(rs.getInt(7));
			p.setPassWord(rs.getString(8));
			
			return p;
		};
	
	}
	
	
	
	


	@Override
	public Collection<GroupPersonnes> findAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveGroup(GroupPersonnes group) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteGroup(GroupPersonnes group) {
		// TODO Auto-generated method stub
		
	}
	
	
}
