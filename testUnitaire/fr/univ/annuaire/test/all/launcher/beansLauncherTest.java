package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.javabeans.GroupPersonnesTest;
import fr.univ.annuaire.test.javabeans.PersonneTest;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	PersonneTest.class,
	GroupPersonnesTest.class,
})
public class beansLauncherTest {
}
