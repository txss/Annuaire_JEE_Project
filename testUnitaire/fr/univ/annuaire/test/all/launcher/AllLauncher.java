package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	beansLauncherTest.class,
	svgLauncherTest.class
})

public class AllLauncher {
}
