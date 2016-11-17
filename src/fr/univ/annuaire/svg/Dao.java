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
		Collection <GroupPersonnes> groupes = new ArrayList<GroupPersonnes>();

		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id, name FROM Groupes_personnes");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				IResultSetToBean<GroupPersonnes> group = (ResultSet r)->{
					GroupPersonnes g = new GroupPersonnes();
					g.setId(r.getInt(1) );
					g.setName(r.getString(2));
					return g;
				};

				groupes.add(group.toBean(rs));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupes;
	}


	@Override
	public void saveGroup(GroupPersonnes group) {
		// TODO Auto-generated method stub

	}


	@Override
	public void deleteGroupByID(GroupPersonnes group) {
		try(Connection connect = newConnection();) {

			String query = 	"DELETE FROM Groupes_personnes WHERE id = ?";
			this.executeUpdate(query, group.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public Personne findPerson(long id) throws DaoException {
		Personne personne = new Personne();

		try(Connection connect = newConnection();) {

			PreparedStatement st = connect.prepareStatement("SELECT id, lastname, firstname, email, website, birthdate, idgroup, passWord FROM Personnes WHERE id = " + id);

			ResultSet rs = st.executeQuery();

			if(!rs.next())
				throw new DaoException("This person with id="+id +" does't exist in this database.");

			IResultSetToBean<Personne> pers = (ResultSet r)->{
				Personne p = new Personne();

				p.setId(r.getInt(1));
				p.setLastName(r.getString(2));
				p.setFirstName(r.getString(3));
				p.setEmail(r.getString(4));
				p.setWebSite(r.getString(5));
				p.setBirthDate(r.getString(6));
				p.setIdGroup(r.getInt(7));
				p.setPassWord(r.getString(8));
				return p;
			};
			personne = pers.toBean(rs);

			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personne;
	}


	@Override
	public void saveNewPerson(Personne personne) throws DaoException {
		try(Connection connect = newConnection();) {

			String query = 	"INSERT INTO personnes(lastname, firstname, email, website, birthdate, idgroup, passWord)"+
					"VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			this.executeUpdate(query, 
					personne.getLastName(),
					personne.getFirstName(),
					personne.getEmail(),
					personne.getWebSite(), 
					personne.getBirthDate(),
					personne.getIdGroup(),
					personne.getPassWord());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Error during saving! Person id -> " + personne.getId() + "has not be saved");
		}
	}//savePerson(Personne personne)


	@Override
	public void deletePersonByID(Personne personne) {
		try(Connection connect = newConnection();) {

			String query = 	"DELETE FROM Personnes WHERE id = ?";
			this.executeUpdate(query, personne.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//deletePerson(Personne personne)



	@Override
	public void updatePerson(Personne personne) {
		try(Connection connect = newConnection();) {

			String query = 	"UPDATE personnes SET lastname = ?, firstname = ?, email = ?, website = ?, birthdate = ?, idgroup = ?, passWord = ? WHERE id = ?";
			
			this.executeUpdate(query, 
					personne.getLastName(),
					personne.getFirstName(),
					personne.getEmail(),
					personne.getWebSite(), 
					personne.getBirthDate(),
					personne.getIdGroup(),
					personne.getPassWord(),
					personne.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//updatePerson(Personne personne)


}
