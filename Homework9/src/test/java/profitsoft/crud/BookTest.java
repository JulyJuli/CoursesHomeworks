package profitsoft.crud;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import profitsoft.beans.Author;
import profitsoft.beans.Book;
import profitsoft.beans.Category;
import profitsoft.configuration.AppConfig;
import profitsoft.services.BookService;

public class BookTest {


	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
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
		bService.updateBook(b4);

		// check for updating
		Book b = bService.selectBookById(b4.getIdBook());
		assertEquals(b.getISBN(),b4.getISBN());

		// delete book
		assertTrue(bService.deleteBookById(b4.getIdBook()));

		// check for deleting
		assertNull(bService.selectBookById(b4.getIdBook()));

	}

	

	@Test
	public void crudBookWithAuthorAndCategoryTest() {

		// insert book with author and category
		Book b = new Book();
		b.setName("TENDER IS THE NIGHT");
		b.setISBN(999999);

		Author a = new Author();
		a.setIdAuthor(1);
		a.setName("ERNEST HEMINGWAY");

		Category c = new Category();
		c.setIdCategory(2);
		c.setName("Biography");

		Set<Category> categories = new HashSet<Category>();
		categories.add(c);
		
		Set<Author> authors = new HashSet<Author>();
		authors.add(a);
		
		bService.insertBookWithAuthorsAndCategories(b, authors, categories);
		assertTrue(b.getIdBook() > 0);

		// delete book
		assertTrue(bService.deleteBookById(b.getIdBook()));

		// check for deleting
		assertNull(bService.selectBookById(b.getIdBook()));

	}
	
}
