package profitsoft.services;

import java.util.List;

import profitsoft.beans.Category;

public interface CategoryService {
	
	/**
	 *  Service allow to select all categories from DB.
	 * 
	 * @return <tt>categories</tt> List Category objects
	 */

	public List<Category> selectAllCategories();


}
