package fr.univ.annuaire.test.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ.annuaire.beans.GroupPersonnes;
import fr.univ.annuaire.manager.GroupManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/univ/annuaire/test/svg/fichier-de-configuration-spring.xml")
public class GroupManagerTest {

	
	@Autowired
	GroupManager groupManager;
	
	
	@Test(timeout = 2000)
	public void saveGroup(){
		GroupPersonnes gr = new GroupPersonnes();
		gr.setName("test"); // the name is generated by the methode
		
		groupManager.saveGroup(gr);
		
		assertNotNull(groupManager.findGroup("test"));
	}
	
	@Test (timeout = 2000)
	public void findGroup() {
		assertNotNull(groupManager.findGroup("default"));
	}

	@Test (timeout = 2000)
	public void findGroupNotPresent() {
		// The exception was catch and treat
		assertNull(groupManager.findGroup("existPas"));
	}
	
	@Test (timeout = 2000)
	public void getAllGroups(){
//		System.out.println(groupManager.getAllGroups());
		assertNotNull(groupManager.getAllGroups());
	}
	
	@Test (timeout = 2000)
	public void deleteGroupExist(){
		GroupPersonnes gr = new GroupPersonnes();
		gr.setId("test");
		gr.setName("test");
		
		groupManager.deleteGroup(gr);
		
		assertNull(groupManager.findGroup("test"));
	}
	
	@Test (timeout = 2000)
	public void deleteGroupNotExit(){
		GroupPersonnes gr = new GroupPersonnes();
		gr.setName("existPas");
		
		groupManager.deleteGroup(gr);
	}
}