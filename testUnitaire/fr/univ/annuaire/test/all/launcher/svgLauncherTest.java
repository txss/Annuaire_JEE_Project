package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.svg.JdbcToolsTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	JdbcToolsTest.class,
})
public class svgLauncherTest {
}