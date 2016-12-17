package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.manager.GroupManagerTest;
import fr.univ.annuaire.test.manager.LoginManagerTest;
import fr.univ.annuaire.test.manager.PersonManagerTest;
import fr.univ.annuaire.test.manager.ProfilManagerTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	GroupManagerTest.class,
	LoginManagerTest.class,
	PersonManagerTest.class,
	ProfilManagerTest.class,
})
public class managerLauncherTest {
}
