package profitsoft.dao;

import java.util.List;

import profitsoft.beans.Author;

public interface AuthorDao {

	/**
	 * Insert author to DB.
	 * 
	 * @param author
	 *            Author object
	 * 
	 * @return id if author was added
	 */
	public int insertAuthor(Author author);

	/**
	 * Update existing author in DB.
	 * 
	 * @param author
	 *            Author object
	 * @return <tt>true</tt> if author was updated
	 */
	public void updateAuthor(Author author);

	
	/**
	 * Find author in DB by specified id.
	 * 
	 * @param id
	 *            author id
	 * @return <tt>author</tt> Author object
	 */
	public Author selectAuthorById(int id);
	
	/**
	 * Select all authors from DB.
	 * 
	 * @return <tt>authors</tt> List Author objects
	 */

	public List<Author> selectAllAuthors();

	/**
	 * Delete existing author in DB.
	 * 
	 * @param id
	 *            Author object id
	 * 
	 * @return <tt>true</tt> if author was deleted
	 */
	public boolean deleteAuthorById(int id);

}
