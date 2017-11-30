package tests.crud;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import profitsoft.beans.Book;
import profitsoft.configuration.ApplicationConfig;
import profitsoft.services.BookService;

public class BookTest {

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	BookService bService = (BookService) context.getBean("bookService");

	
	@Test
	public void crudBookTest() {

		// insert book
		Book b4 = new Book();
		b4.setName("TENDER IS THE NIGHT");
		b4.setISBN(999999);
		b4.setIdBook(bService.insertBook(b4));
		assertTrue(b4.getIdBook() > 0);

		// updating book
		b4.setISBN(11111111);
		assertTrue(bService.updateBook(b4));

		// check for updating
		Book b = bService.selectBookById(b4.getIdBook());
		assertEquals(b4.getISBN(), b.getISBN());

		// delete book
		assertTrue(bService.deleteBookById(b4.getIdBook()));

		// check for deleting
		assertNull(bService.selectBookById(b4.getIdBook()));

	}

}
