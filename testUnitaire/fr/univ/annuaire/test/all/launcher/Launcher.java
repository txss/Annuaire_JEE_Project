package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import fr.univ.annuaire.test.javabeans.beansLauncherTest;
import fr.univ.annuaire.test.svg.svgLauncherTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	beansLauncherTest.class,
	svgLauncherTest.class
})

public class Launcher {
}
