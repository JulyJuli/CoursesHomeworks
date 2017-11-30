package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.crud.AuthorTest;
import tests.crud.BookTest;


@RunWith(Suite.class)
@SuiteClasses(value = {BookTest.class,AuthorTest.class})
public class AllTests {

}
