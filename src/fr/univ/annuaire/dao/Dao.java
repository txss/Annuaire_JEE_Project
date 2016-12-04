package fr.univ.annuaire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.svg.IResultSetToBean;
import fr.univ.annuaire.svg.JdbcTools;


public class Dao extends JdbcTools implements GroupDao, PersonneDao {


	public Dao() {
		super();
	}


	@Override
	public Collection<GroupPersonnes> findAllGroups() {
		Collection <GroupPersonnes> groupes = new ArrayList<GroupPersonnes>();

		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id_group, name_group FROM \"GROUPE\"");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {

				IResultSetToBean<GroupPersonnes> group = (ResultSet r)->{
					GroupPersonnes g = new GroupPersonnes();
					g.setId(r.getString(1) );
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
	public void saveGroup(GroupPersonnes group) throws DaoException {
		try(Connection connect = newConnection();) {

			String query = 	"INSERT INTO \"GROUPE\"(id_group, name_group) VALUES (?, ?)";
			
			this.executeUpdate(query,
					group.getId(),
					group.getName());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("This group (id:"+group.getId()+") is alerady present in the database. Use the methode UpdateGroupByID for change the values of group.");
		}
	}


	@Override
	public void deleteGroup(GroupPersonnes group) {
		try(Connection connect = newConnection();) {

			String query = 	"DELETE FROM \"GROUPE\" WHERE id_group = ?";
			this.executeUpdate(query, group.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public GroupPersonnes findGroup(GroupPersonnes group) throws DaoException {
		GroupPersonnes groupPersonnes = new GroupPersonnes();

		try(Connection connect = newConnection();) {

			PreparedStatement st = connect.prepareStatement("SELECT id_group, name_group FROM \"GROUPE\" WHERE id_group = '"+ group.getId()+"'");
			ResultSet rs = st.executeQuery();

			if(!rs.next())
				throw new DaoException("This group with id="+ group.getId() +" does't exist in this database.");

			IResultSetToBean<GroupPersonnes> gr = (ResultSet r)->{
				GroupPersonnes g = new GroupPersonnes();

				g.setId(r.getString(1));
				g.setName(r.getString(2));
				return g;
			};
			groupPersonnes = gr.toBean(rs);

			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return groupPersonnes;
	}
	

	@Override
	public GroupPersonnes findGroupByName(String groupName) throws DaoException{
		GroupPersonnes groupPersonnes = new GroupPersonnes();

		try(Connection connect = newConnection();) {

			PreparedStatement st = connect.prepareStatement("SELECT id_group, name_group FROM \"GROUPE\" WHERE name_group = '" + groupName+"'");
			ResultSet rs = st.executeQuery();

			if(!rs.next())
				throw new DaoException("This Group with name="+ groupName +" does't exist in this database.");
			
			IResultSetToBean<GroupPersonnes> gr = (ResultSet r)->{
				GroupPersonnes g = new GroupPersonnes();
				g.setId(r.getString(1) );
				g.setName(r.getString(2));
				return g;
			};

			groupPersonnes = gr.toBean(rs);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupPersonnes;
	}
	

	@Override
	public void UpdateGroup(GroupPersonnes group) {
		try(Connection connect = newConnection();) {

			String query = 	"UPDATE \"GROUPE\" SET name_group = ? WHERE id_group = ?";
			
			this.executeUpdate(query,
					group.getName(),
					group.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public Collection<Personne> findAllPersonsInGroup(long groupId) {
		Collection <Personne> personnes = new ArrayList<Personne>();

		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id_person, lastname_person, firstname_person, web_person, id_group FROM \"PERSONNE\" WHERE id_group = '" + groupId + "'");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				IResultSetToBean<Personne> personne = (ResultSet r)->{
					Personne p = new Personne();

					p.setId(r.getInt(1) );
					p.setLastName(r.getString(2) );
					p.setFirstName(r.getString(3) );
					p.setWebSite(r.getString(4));
					p.setIdGroup(r.getString(5));

					return p;
				};
				personnes.add(personne.toBean(rs));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personnes;
	}
	

	@Override 
	public Collection<Personne> findAllPersons() {
		Collection <Personne> personnes = new ArrayList<Personne>();

		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id_person, lastname_person, firstname_person, web_person, id_group FROM \"PERSONNE\"");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				IResultSetToBean<Personne> personne = (ResultSet r)->{
					Personne p = new Personne();

					p.setId(r.getInt(1) );
					p.setLastName(r.getString(2) );
					p.setFirstName(r.getString(3) );
					p.setWebSite(r.getString(4));
					p.setIdGroup(r.getString(5));

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
	public Personne findPersonByID(long id) throws DaoException {
		Personne personne = new Personne();

		try(Connection connect = newConnection();) {

			PreparedStatement st = connect.prepareStatement("SELECT id_person, lastname_person, firstname_person, email_person, web_person, birthday_person, id_group, passwd_person FROM \"PERSONNE\" WHERE id_person = " + id);

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
				p.setBirthDate(r.getDate(6));
				p.setIdGroup(r.getString(7));
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
	public Personne findPersonByEmail(String email) throws DaoException {
		Personne personne = new Personne();

		try(Connection connect = newConnection();) {

			PreparedStatement st = connect.prepareStatement("SELECT id_person, lastname_person, firstname_person, email_person, web_person, birthday_person, id_group, passwd_person FROM \"PERSONNE\" WHERE email_person = '" + email+"'");

			ResultSet rs = st.executeQuery();

			if(!rs.next())
				throw new DaoException("This person with email="+email +" does't exist in this database.");

			IResultSetToBean<Personne> pers = (ResultSet r)->{
				Personne p = new Personne();

				p.setId(r.getInt(1));
				p.setLastName(r.getString(2));
				p.setFirstName(r.getString(3));
				p.setEmail(r.getString(4));
				p.setWebSite(r.getString(5));
				p.setBirthDate(r.getDate(6));
				p.setIdGroup(r.getString(7));
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
	public void insertPerson(Personne personne){
		try(Connection connect = newConnection();) {

			String query = 	"INSERT INTO \"PERSONNE\" (lastname_person, firstname_person, email_person, web_person, birthday_person, id_group, passwd_person)"+
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
		}
	}//savePerson(Personne personne)


	@Override
	public void deletePerson(Personne personne) {
		try(Connection connect = newConnection();) {

			String query = 	"DELETE FROM \"PERSONNE\" WHERE id_person = ?";
			this.executeUpdate(query, personne.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//deletePerson(Personne personne)


	@Override
	public void updatePerson(Personne personne) {
		try(Connection connect = newConnection();) {

			String query = 	"UPDATE \"PERSONNE\" SET lastname_person = ?, firstname_person = ?, email_person = ?, web_person = ?, birthday_person = ?, id_group = ?, passwd_person = ? WHERE id_person = ?";
			
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


	@Override
	public Collection<Personne> searchKeywordInPersons(String search) {
		Collection <Personne> personnes = new ArrayList<Personne>();

		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id_person, lastname_person, firstname_person, web_person, id_group FROM \"PERSONNE\" "
					+ "WHERE lastname_person LIKE '%" + search + "%' OR firstname_person LIKE  '%" + search + "%' OR web_person LIKE  '%" + search + "%'");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				IResultSetToBean<Personne> personne = (ResultSet r)->{
					Personne p = new Personne();
					p.setId(r.getInt(1) );
					p.setLastName(r.getString(2) );
					p.setFirstName(r.getString(3) );
					p.setWebSite(r.getString(4));
					p.setIdGroup(r.getString(5));
					return p;
				};
				
				personnes.add(personne.toBean(rs));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personnes;
	}//searchKeywordInPersons


}
