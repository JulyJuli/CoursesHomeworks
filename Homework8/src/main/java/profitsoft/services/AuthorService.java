package profitsoft.services;

import java.util.List;

import profitsoft.beans.Author;

public interface AuthorService {

	/**
	 * Service allow to insert author to DB.
	 * 
	 * @param author
	 *            Author object
	 * 
	 * @return id if author was added
	 */
	public int insertAuthor(Author author);

	/**
	 *  Service allow to update existing author in DB.
	 * 
	 * @param author
	 *            Author object
	 * @return <tt>true</tt> if author was updated
	 */
	public boolean updateAuthor(Author author);

	
	/**
	 *  Service allow to find author in DB by specified id.
	 * 
	 * @param id
	 *            author id
	 * @return <tt>author</tt> Author object
	 */
	public Author selectAuthorById(int id);
	
	/**
	 *  Service allow to select all authors from DB.
	 * 
	 * @return <tt>authors</tt> List Author objects
	 */

	public List<Author> selectAllAuthors();

	/**
	 *  Service allow to delete existing author in DB.
	 * 
	 * @param id
	 *            Author object id
	 * 
	 * @return <tt>true</tt> if author was deleted
	 */
	public boolean deleteAuthorById(int id);

}
