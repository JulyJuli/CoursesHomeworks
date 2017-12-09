package profitsoft.dao;

import java.util.List;

import profitsoft.beans.Category;

public interface CategoryDao {
	
	/**
	 * Select all categories from DB.
	 * 
	 * @return <tt>categories</tt> List Category objects
	 */

	public List<Category> selectAllCategories();

}
