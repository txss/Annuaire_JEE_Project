package fr.univ.annuaire.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import fr.univ.annuaire.beans.Login;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@ContextConfiguration(locations = "classpath:fr/univ/annuaire/manager/fichier-de-configuration-spring.xml")
public class LoginManager {

	@Autowired
	Dao dao;
	
	private Login l;
	/**
	 * default constructor
	 */
	public LoginManager(Login login) {
		this.l = login;
	}
	
	public boolean checkLogin() throws DaoException{
		System.out.println("lllll" +l.getEmail());
//		System.out.println(dao.getPassword());
//		System.out.println(dao.findAllGroups());
		
//		Personne p = dao.findPersonByEmail(l.getEmail());
//		System.out.println(p);
//		System.out.println("pppppppppppp" + p.getEmail());
		
//		if(p.getEmail().equals(l.getEmail()))
//			if(p.getPassWord().equals(l.getPassWord()))
//				return true;
		
		return false;
	}
	
}
