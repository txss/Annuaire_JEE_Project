package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.dao.DaoGroupesTest;
import fr.univ.annuaire.test.dao.DaoPersonnesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	DaoPersonnesTest.class,
	DaoGroupesTest.class,
})

public class daoLauncherTest {
}
