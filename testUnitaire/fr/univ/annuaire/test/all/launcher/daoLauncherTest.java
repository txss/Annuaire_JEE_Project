package fr.univ.annuaire.test.all.launcher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fr.univ.annuaire.test.dao.DaoTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	DaoTest.class
})

public class daoLauncherTest {
}
