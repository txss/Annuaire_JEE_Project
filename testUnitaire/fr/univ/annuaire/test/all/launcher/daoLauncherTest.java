package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.dao.DaoGroupeErrorTest;
import fr.univ.annuaire.test.dao.DaoGroupesTest;
import fr.univ.annuaire.test.dao.DaoPersonnesErrorTest;
import fr.univ.annuaire.test.dao.DaoPersonnesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	DaoPersonnesTest.class,
	DaoGroupesTest.class,
	DaoGroupeErrorTest.class,
	DaoPersonnesErrorTest.class,
})

public class daoLauncherTest {
}
