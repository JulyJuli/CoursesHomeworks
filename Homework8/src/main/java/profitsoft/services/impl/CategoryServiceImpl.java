package profitsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import profitsoft.beans.Category;
import profitsoft.dao.CategoryDao;
import profitsoft.services.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	
	public List<Category> selectAllCategories() {
		return categoryDao.selectAllCategories();
	}
}
