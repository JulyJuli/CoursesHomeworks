
import java.sql.SQLException;
import java.util.List;
import db.Db_Manager;
import entity.Author;
import entity.Book;
import entity.Book_has_Author;
import entity.Book_has_Author_And_Category;
import entity.Category;

public class MainClass {

	public static void main(String[] args) throws SQLException {

		Db_Manager manager = new Db_Manager();

		System.out.println("List of all books: ");
		List<Book> books = manager.selectAllBooks();

		for (Book b : books) {
			System.out.println(b);
		}

		System.out.println("------------------------------");
		System.out.println("List of categories: ");

		List<Category> categories = manager.selectAllCategories();

		for (Category c : categories) {
			System.out.println(c);
		}
		System.out.println("------------------------------");
		System.out.println("List of authors: ");

		List<Author> authors = manager.selectAllAuthors();

		for (Author a : authors) {
			System.out.println(a);
		}
		System.out.println("------------------------------");
		System.out.println("Get book with author and category:");

		List<Book_has_Author_And_Category> bhac = manager.selectBookWithAuthorAndCategory();
		for (Book_has_Author_And_Category b : bhac)
			System.out.println(b);

		System.out.println("------------------------------");
		System.out.println("Inserting book.. ");

		Book b = new Book();
		b.setName("BLEAK HOUcE");
		b.setISBN(97801414);
		int i = manager.insertBook(b);

		System.out.println("Get book by generated id: ");
		Book b1 = manager.selectBookById(i);
		System.out.println(b1);

		System.out.println("Update this book..");
		Book b3 = new Book();
		b3.setIdBook(i);
		b3.setName("BLEAK HOUSE");
		b3.setISBN(123455);
		manager.updateBook(b3);
		System.out.println();

		System.out.println("View changes...");
		System.out.println(manager.selectBookById(i));

		System.out.println("Deleting book..." + "\n");
		manager.deleteBookById(i);

		System.out.println("List of books: ");
		List<Book> books2 = manager.selectAllBooks();

		for (Book tmpBook : books2) {
			System.out.println(tmpBook);
		}

		System.out.println("------------------------------");
		System.out.println("Inserting author...");
		Author a = new Author();
		a.setName("RAY BRADBUuRY");
		int id = manager.insertAuthor(a);

		System.out.println("Selecting author by generated id:");
		System.out.println(manager.selectAuthorById(id));

		System.out.println("Updating inserted author....");
		Author a1 = new Author();
		a1.setName("RAY BRADBURY");
		a1.setIdAuthor(id);
		manager.updateAuthor(a1);

		System.out.println("View changes...");
		System.out.println(manager.selectAuthorById(id));

		System.out.println("\n"+"Deleting inserted author:");
		manager.deleteAuthorById(id);

		System.out.println("List of authors: ");
		List<Author> a3 = manager.selectAllAuthors();

		for (Author auth : a3) {
			System.out.println(auth);
		}

		Book b4 = new Book();
		b4.setName("TENDER IS THE NIGHT");
		b4.setISBN(122345);
		int i2 = manager.insertBook(b4);

		System.out.println("------------------------------");
		System.out.println("Adding author for existing book..");
		Book_has_Author book = new Book_has_Author();
		book.setIdAuthor(3);
		book.setIdBook(i2);
		manager.insertBookHasAuthor(book);

		List<Book_has_Author> bha3 = manager.selectBookWithAuthor();
		for (Book_has_Author tmp : bha3)
			System.out.println(tmp);

		
		System.out.println("Updating  entry...");
		manager.updateBookHasAuthor_idAuthor(book, 4);

		System.out.println("After updating: ");
		List<Book_has_Author> bha2 = manager.selectBookWithAuthor();
		for (Book_has_Author tmp : bha2)
			System.out.println(tmp);

		System.out.println("Deleting entry: ");
		manager.deleteFromBookHasAuthor(i2);

		System.out.println("After deleting: ");
		List<Book_has_Author> bha4 = manager.selectBookWithAuthor();
		for (Book_has_Author tmp : bha4)
			System.out.println(tmp);

		System.out.println("------------------------------");
		System.out.println("Get books of certain author with special category:");

		List<Book_has_Author_And_Category> bhaac = manager
				.selectBookWithAuthorAndCathegoryByAuthorAndCategory("CHARLES DICKENS", "Novel");
		for (Book_has_Author_And_Category tmp : bhaac)
			System.out.println(tmp);

	}
}