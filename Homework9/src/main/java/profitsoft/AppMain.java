package profitsoft;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import profitsoft.beans.Book;
import profitsoft.configuration.AppConfig;
import profitsoft.services.BookService;

public class AppMain {

	public static Logger log = Logger.getAnonymousLogger();
	
	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		BookService bService = (BookService) context.getBean("bookService");
	
		System.out.println("Selecting books from specific category:");
		List<Book> books1 = bService.selectBooksFromCategory("Fiction");
		for (Book book : books1) {
			System.out.println(book);
		}

		log.info("----------------------------------------");
		System.out.println("Selecting books by specific category and certain author:");
		List<Book> books = bService.selectBooksByCategoryAndAuthor("CHARLES DICKENS", "Biography");
		for (Book book : books) {
			System.out.println(book);
		}
		context.close();
	}
}
