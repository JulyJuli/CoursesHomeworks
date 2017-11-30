package profitsoft;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import profitsoft.beans.Author;
import profitsoft.beans.BookWithAuthorAndCategory;
import profitsoft.beans.Category;
import profitsoft.configuration.ApplicationConfig;
import profitsoft.services.AuthorService;
import profitsoft.services.BookService;
import profitsoft.services.CategoryService;

/**
 * The AppMain class demonstrates some methods for working with DB
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-27
 */
public class AppMain {
	
	static Logger log = Logger.getAnonymousLogger();

	public static void main(String args[]) throws SQLException {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		System.out.println("\n" +"Selecting availible categories: ");
		CategoryService cService = (CategoryService) context.getBean("categoryService");

		List<Category> categories = cService.selectAllCategories();
		for (Category c : categories) {
			log.info(c.toString());
		}

		System.out.println("\n" + "Selecting authors from DB: ");
		AuthorService aService = (AuthorService) context.getBean("authorService");

		List<Author> authors = aService.selectAllAuthors();
		for (Author a : authors) {
			log.info(a.toString());
		}

		System.out.println("\n" + "Selecting full book information: ");
		BookService bService = (BookService) context.getBean("bookService");

		List<BookWithAuthorAndCategory> books2 = bService.selectAllBooksWithCategoryAndAuthor();
		for (BookWithAuthorAndCategory b : books2) {
			log.info(b.toString());
		}
		
		System.out.println("\n" + "Selecting books of certain author: ");
		List<BookWithAuthorAndCategory> books3 = bService.selectAllAuthorsBooks("CHARLES DICKENS");
		for (BookWithAuthorAndCategory b2 : books3) {
			log.info(b2.toString());
		}

		System.out.println("\n");
		context.close();
	}
}