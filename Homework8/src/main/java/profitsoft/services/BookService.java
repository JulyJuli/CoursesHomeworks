package profitsoft.services;

import java.util.List;

import profitsoft.beans.Book;
import profitsoft.beans.BookWithAuthorAndCategory;

public interface BookService {
	/**
	 *  Service allow to insert book to DB.
	 * 
	 * @param book
	 *            book object
	 * 
	 * @return id if book was added
	 */
	public int insertBook(Book book);

	/**
	 *  Service allow to update existing book in DB.
	 * 
	 * @param book
	 *            Book object
	 * @return <tt>true</tt> if book was updated
	 */
	public boolean updateBook(Book book);

	/**
	 *  Service allow to find book in DB by specified id.
	 * 
	 * @param id
	 *            book's id
	 * @return <tt>book</tt> Book object
	 */
	public Book selectBookById(int id);

	/**
	 *  Service allow to select all books from DB.
	 * 
	 * @return <tt>book</tt> List of Book objects
	 */
	public List<Book> selectAllBooks();

	/**
	 *  Service allow to delete existing book in DB.
	 * 
	 * @param id
	 *            Book object id
	 * 
	 * @return <tt>true</tt> if book was deleted
	 */
	public boolean deleteBookById(int id);

	/**
	 *  Service allow to select all books with author and category from DB.
	 * 
	 * @return <tt>book</tt> List of Book objects
	 */
	public List<BookWithAuthorAndCategory> selectAllBooksWithCategoryAndAuthor();

	/**
	 * Service allow to find book in DB by author name.
	 * 
	 * @param author
	 *            author of book
	 * @return <tt>book</tt> List of Book objects
	 */
	public List<BookWithAuthorAndCategory> selectAllAuthorsBooks(String author);

}
