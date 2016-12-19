package fr.univ.annuaire.test.generData;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ.annuaire.beans.Personne;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class PersonnesGeneratorTest {

	@Autowired
	Dao dao;
	
	String prenoms [] 	= new String[]{"Jean", "Charles", "Luc", "Florian", "Kevin", "Benjamin", "Thomas", "Nicolas", "Martine", "Dominique", "Julie", "Marie", "Julien", "Fabrice", "Emilie", "Bernadette"};
	String noms[]		= new String[]{"Clavier", "Darm", "Haut", "As", "Gill", "Altenne", "Deawood", "Lion", "Power"};
	
	String groupName [] = new String []{"Maths", "Informatique", "Chimie", "Physique", "Histoire", "Geographie", "STAPS", "Biologie", "Economie", "Science Social", "paleontologie"};
	String cursus []	= new String []{"Licence", "Master", "IUT", "Doctorat"};
	
	@Test
	public void insertPerson() throws DaoException{
		
		int curs = 0;
		int grp = 0;
		
		for(int i = 0; i < prenoms.length; i++)
			for(int j = 0; j < noms.length; j++){
				Personne p = new Personne();
				if(curs == cursus.length) curs = 0;
				if(grp == groupName.length) grp = 0;
				
				String GroupName = cursus[curs]+" "+groupName[grp];
				String id = GroupName.toLowerCase().replace(" ", "-");
				
				p.setFirstName(prenoms[i]);
				p.setLastName(noms[j]);
				p.setEmail(prenoms[i]+noms[j]+i+j+"@live.fr");
				p.setIdGroup(id);
				p.setBirthDate("1989-05-23");
				p.setWebSite("monbeausiteweb.com");
				p.setPassWord("password");
				dao.insertPerson(p);
				curs++;
				grp++;
			}
			
	}

}
