package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.svg.JdbcToolsPGTestHC;
import fr.univ.annuaire.test.svg.JdbcToolsPGTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	JdbcToolsPGTest.class,
	JdbcToolsPGTestHC.class,
})
public class svgLauncherTest {
}
