package tests.crud;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import profitsoft.beans.Author;
import profitsoft.configuration.ApplicationConfig;
import profitsoft.services.AuthorService;

public class AuthorTest {

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	AuthorService aService = (AuthorService) context.getBean("authorService");

	@Test
	public void CRUDAuthorTest() throws SQLException {

		// insert author
		Author a = new Author();
		a.setName("RAY BRADBUuRY");
		a.setIdAuthor(aService.insertAuthor(a));
		assertTrue(a.getIdAuthor() > 0);

		// updating author
		a.setName("RAY BRADBURY");
		assertTrue(aService.updateAuthor(a));

		// check for updating
		Author a2 = aService.selectAuthorById(a.getIdAuthor());
		assertEquals(a2.getName(), a.getName());

		// delete author
		assertTrue(aService.deleteAuthorById(a.getIdAuthor()));

		// check for deleting
		assertNull(aService.selectAuthorById(a.getIdAuthor()));

	}

}