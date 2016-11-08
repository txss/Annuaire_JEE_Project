package fr.univ.annuaire.svg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import fr.univ.annuaire.beans.Personne;

public class Dao extends JdbcTools {
	
	
	public Collection<Personne> findPersons() throws DaoException {
		Collection <Personne> personnes = new ArrayList<Personne>();
		
		try(Connection connect = newConnection();) {
			PreparedStatement st = connect.prepareStatement("SELECT id, Nom, Prenom, Age FROM Personne");
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Personne p = new Personne();
				p.toBean(rs);
				personnes.add(p);
	        }
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personnes;
	}//findPerson()
	
	
	
	
	
}
