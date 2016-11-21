package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.dao.DaoGroupesTest;
import fr.univ.annuaire.test.dao.DaoPersonnesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	DaoGroupesTest.class,
	DaoPersonnesTest.class,
})

public class daoLauncherTest {
}
