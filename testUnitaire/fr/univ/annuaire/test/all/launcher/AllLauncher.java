package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.utility.EmailTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	beansLauncherTest.class,
	svgLauncherTest.class,
	daoLauncherTest.class,
	managerLauncherTest.class,
	controllerLauncherTest.class,
	EmailTest.class,
})

public class AllLauncher {
}
