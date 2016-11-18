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
	public void saveGroup(GroupPersonnes group) throws DaoException {
		try(Connection connect = newConnection();) {

			String query = 	"INSERT INTO Groupes_Personnes(id, name) VALUES (?, ?)";
			
			this.executeUpdate(query,
					group.getId(),
					group.getName());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("This group (id:"+group.getId()+") is alerady present in the database. Use the methode UpdateGroupByID for change the values of group.");
		}
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
	public GroupPersonnes findGroupByID(GroupPersonnes group) throws DaoException {
		GroupPersonnes groupPersonnes = new GroupPersonnes();

		try(Connection connect = newConnection();) {

			PreparedStatement st = connect.prepareStatement("SELECT id, name FROM Groupes_Personnes WHERE id = " + group.getId());

			ResultSet rs = st.executeQuery();

			if(!rs.next())
				throw new DaoException("This group with id="+ group.getId() +" does't exist in this database.");

			IResultSetToBean<GroupPersonnes> gr = (ResultSet r)->{
				GroupPersonnes g = new GroupPersonnes();

				g.setId(r.getInt(1));
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
	public GroupPersonnes findGroupByName(GroupPersonnes group){
		GroupPersonnes groupPersonnes = new GroupPersonnes();


		try(Connection connect = newConnection();) {

			PreparedStatement st = connect.prepareStatement("SELECT id, name FROM Groupes_Personnes WHERE name = \"" + group.getName()+"\"");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				IResultSetToBean<GroupPersonnes> gr = (ResultSet r)->{
					GroupPersonnes g = new GroupPersonnes();
					g.setId(r.getInt(1) );
					g.setName(r.getString(2));
					return g;
				};

				groupPersonnes = gr.toBean(rs);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return groupPersonnes;
	}
	

	@Override
	public Collection<Personne> findAllPersonsInGroup(long groupId) {
		Collection <Personne> personnes = new ArrayList<Personne>();

		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id, lastname, firstname, website, idgroup FROM Personnes WHERE idgroup = " + groupId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				IResultSetToBean<Personne> personne = (ResultSet r)->{
					Personne p = new Personne();

					p.setId(r.getInt(1) );
					p.setLastName(r.getString(2) );
					p.setFirstName(r.getString(3) );
					p.setWebSite(r.getString(4));
					p.setIdGroup(r.getInt(5));

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
	public void UpdateGroupByID(GroupPersonnes group) {
		try(Connection connect = newConnection();) {

			String query = 	"UPDATE Groupes_Personnes SET name = ? WHERE id = ?";
			
			this.executeUpdate(query,
					group.getName(),
					group.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public Personne findPersonByID(long id) throws DaoException {
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
			throw new DaoException("This person is not present in the database, person id: "+ id);
		}

		return personne;
	}


	@Override
	public void saveNewPerson(Personne personne){
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
