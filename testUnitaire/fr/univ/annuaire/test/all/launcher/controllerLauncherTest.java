package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.controller.AccueilControllerTest;
import fr.univ.annuaire.test.controller.GroupControllerTest;
import fr.univ.annuaire.test.controller.LoginControllerTest;
import fr.univ.annuaire.test.controller.PersonControllerTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	AccueilControllerTest.class,
	GroupControllerTest.class,
	LoginControllerTest.class,
	PersonControllerTest.class,
})
public class controllerLauncherTest {
}
