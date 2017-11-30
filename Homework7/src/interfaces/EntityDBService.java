package interfaces;

/**
 * Interface for implement CRUD operations.
 *
 * @version 1.0
 */

public interface EntityDBService<T> {
	/**
	 * Method load existing T element by id
	 * 
	 * @param id
	 *            Looking for element by passed id.
	 *
	 * 
	 * @return T
	 */
	T load(long id);

	
	/**
	 * Method save a new T element
	 * 
	 * @param entity
	 *            A new entity for adding it to the xml file
	 *
	 */
	void save(T entity);

	
	/**
	 * Method update existing value of T element
	 * 
	 * @param entity
	 *            T entity for updating. Looking for existing element by id
	 *
	 */
	void update(T entity);

	
	/**
	 * Method delete T element by id
	 * 
	 * @param id
	 *            Looking for existing element by id and remove it
	 *
	 */
	void delete(long id);
}
