package profitsoft;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import profitsoft.crud.AuthorTest;
import profitsoft.crud.BookTest;


@RunWith(Suite.class)
@SuiteClasses(value = {BookTest.class,AuthorTest.class})
public class AllTests {

}
