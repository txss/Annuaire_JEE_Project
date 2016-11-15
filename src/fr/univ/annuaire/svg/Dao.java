package fr.univ.annuaire.svg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.beans.Personne;


public class Dao extends JdbcTools implements GroupDao, PersonneDao {

	
	public Dao() {
		super();
	}



//	public void bidon(){
//		//		IResultSetToBean<Personne> per = new IResultSetToBean<Personne>() {
//		//			
//		//			@Override
//		//			public Personne toBean(ResultSet rs) throws SQLException {
//		//				
//		//				return null;
//		//			}
//		//		}; 
//
//		IResultSetToBean<Personne> personne = (ResultSet rs)->{
//			Personne p = new Personne();
//
//			p.setId(rs.getInt(1) );
//			p.setLastName(rs.getString(2) );
//			p.setFirstName(rs.getString(3) );
//			p.setEmail(rs.getString(4));
//			p.setWebSite(rs.getString(5));
//			p.setBirthDate(rs.getDate(6));
//			p.setIdGroup(rs.getInt(7));
//			p.setPassWord(rs.getString(8));
//
//			return p;
//		};
//
//	}






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


	@Override
	public Collection<Personne> findAllPersonsInGroup(long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override 
	public Collection<Personne> findAllPersons() {
		Collection <Personne> personnes = new ArrayList<Personne>();

		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id, lastname, firstname, email, website, birthdate, idgroup, passWord FROM Personnes");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				IResultSetToBean<Personne> personne = (ResultSet r)->{
					Personne p = new Personne();

					p.setId(r.getInt(1) );
					p.setLastName(r.getString(2) );
					p.setFirstName(r.getString(3) );
					p.setEmail(r.getString(4));
					p.setWebSite(r.getString(5));
					p.setBirthDate(r.getString(6));
					p.setIdGroup(r.getInt(7));
					p.setPassWord(r.getString(8));
					
					return p;
				};
				personnes.add(personne.toBean(rs));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personnes;
	}//findAllPersons()

			
	@Override
	public Personne findPerson(long id) {
		Personne personne = new Personne();

		try(Connection connect = newConnection();) {
			
			PreparedStatement st = connect.prepareStatement("SELECT id, lastname, firstname, email, website, birthdate, idgroup, passWord "
															+ "FROM Personnes"
															+ "WHERE id = " + id);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				IResultSetToBean<Personne> pers = (ResultSet r)->{
					Personne p = new Personne();

					p.setId(r.getInt(1) );
					p.setLastName(r.getString(2) );
					p.setFirstName(r.getString(3) );
					p.setEmail(r.getString(4));
					p.setWebSite(r.getString(5));
					p.setBirthDate(r.getString(6));
					p.setIdGroup(r.getInt(7));
					p.setPassWord(r.getString(8));
					return p;
				};
				personne = pers.toBean(rs);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personne;
	}


	@Override
	public void savePerson(Personne personne) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deletePerson(Personne personne) {
		// TODO Auto-generated method stub

	}


}
