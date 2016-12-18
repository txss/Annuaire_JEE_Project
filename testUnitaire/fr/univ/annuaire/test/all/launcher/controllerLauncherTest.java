package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.controller.AccueilControllerTest;
import fr.univ.annuaire.test.controller.GroupControllerTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	AccueilControllerTest.class,
	GroupControllerTest.class,
	
})
public class controllerLauncherTest {
}
