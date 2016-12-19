package fr.univ.annuaire.test.generData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.dao.Dao;
import fr.univ.annuaire.dao.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class GroupePersonnesGeneratorTest {

	@Autowired
	Dao dao;
	
	String groupName [] = new String []{"Maths", "Informatique", "Chimie", "Physique", "Histoire", "Geographie", "STAPS", "Biologie", "Economie", "Science Social", "paleontologie"};
	String cursus []	= new String []{"Licence", "Master", "IUT", "Doctorat"};
	
	
	@Test
	public void insertGroup() throws DaoException {
		for(int i = 0; i < groupName.length; i++)
			for(int j = 0; j < cursus.length; j++){
				GroupPersonnes g = new GroupPersonnes();
				String name = cursus[j]+" "+groupName[i];
				String id = name.toLowerCase().replace(" ", "-");
				g.setId(id);
				g.setName(name);

				dao.saveGroup(g);
			}
	}

}
