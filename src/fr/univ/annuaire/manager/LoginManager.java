package fr.univ.annuaire.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.annuaire.beans.Login;
import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@Service
public class LoginManager {

	@Autowired
	Dao dao;
	
	/**
	 * default constructor
	 */
	public LoginManager() {}
	
//	@PostConstruct
//	public void init (){
//		dao.findAllGroups();
//	}
	
	public boolean checkLogin(Login login) throws DaoException{
		Personne p = dao.findPersonByEmail(login.getEmail());
		
		if(p.getEmail().equals(login.getEmail()))
			if(p.getPassWord().equals(login.getPassWord()))
				return true;
		
		return false;
	}
	
}
