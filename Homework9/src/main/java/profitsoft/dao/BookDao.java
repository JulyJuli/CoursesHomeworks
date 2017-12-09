package profitsoft.dao;

import java.util.List;
import java.util.Set;

import profitsoft.beans.Author;
import profitsoft.beans.Book;
import profitsoft.beans.Category;

public interface BookDao {
	/**
	 * Insert book to DB.
	 * 
	 * @param book
	 *            book object
	 * 
	 * @return id if book was added
	 */
	public int insertBook(Book book);

	/**
	 * Update existing book in DB.
	 * 
	 * @param book
	 *            Book object
	 * @return <tt>true</tt> if book was updated
	 */
	public void updateBook(Book book);

	/**
	 * Find book in DB by specified id.
	 * 
	 * @param id
	 *            book's id
	 * @return <tt>book</tt> Book object
	 */
	public Book selectBookById(int id);

	/**
	 * Select all books from DB.
	 * 
	 * @return <tt>book</tt> List of Book objects
	 */
	public List<Book> selectAllBooks();

	/**
	 * Select all books from DB by specific category and certain author .
	 * 
	 * @param author
	 *            Author object
	 * @param category
	 *            Category object
	 * 
	 * @return <tt>book</tt> List of Book objects
	 */
	public List<Book> selectBooksByCategoryAndAuthor(String author, String category);

	/**
	 * Insert book to DB with category and certain author .
	 * 
	 * @param book
	 *            Book object
	 * @param author
	 *            Author object
	 * @param category
	 *            Category object
	 * 
	 * @return <tt>book</tt> List of Book objects
	 */
	public int insertBookWithAuthorsAndCategories(Book book, Set<Author> authors, Set<Category> categories);

	/**
	 * Delete existing book in DB.
	 * 
	 * @param id
	 *            Book object id
	 * 
	 * @return <tt>true</tt> if book was deleted
	 */
	public boolean deleteBookById(int id);

	/**
	 * Select all books of certain author from DB.
	 * 
	 * @return <tt>book</tt> List of Book objects
	 */
	public List<Book> selectAuthorBook(String author);

	/**
	 * Find book in DB by category name.
	 * 
	 * @param category
	 *            category of book
	 * @return <tt>book</tt> List of Book objects
	 */
	public List<Book> selectBooksFromCategory(String category);

	/**
	 * Insert book with author to DB.
	 * 
	 * @param book
	 *            book object
	 * @param author
	 *            author of book
	 * 
	 * @return id if book was added
	 */
	public int insertBookWithAuthors(Book book, Set<Author> authors);

}
