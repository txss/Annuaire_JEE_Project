package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.controller.AccueilControllerTest;
import fr.univ.annuaire.test.controller.GroupControllerTest;
import fr.univ.annuaire.test.controller.LoginControllerTest;
import fr.univ.annuaire.test.controller.PersonControllerTest;
import fr.univ.annuaire.test.controller.ProfilControllerTest;
import fr.univ.annuaire.test.controller.ViewsDispatcherControllerTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	AccueilControllerTest.class,
	GroupControllerTest.class,
	LoginControllerTest.class,
	PersonControllerTest.class,
	ProfilControllerTest.class,
	ViewsDispatcherControllerTest.class,
})
public class controllerLauncherTest {
}
