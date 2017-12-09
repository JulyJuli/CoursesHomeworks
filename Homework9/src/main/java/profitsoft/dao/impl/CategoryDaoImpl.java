package profitsoft.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import profitsoft.beans.Category;
import profitsoft.dao.AbstractDao;
import profitsoft.dao.CategoryDao;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao implements CategoryDao {

	@SuppressWarnings("unchecked")
	public List<Category> selectAllCategories() {
		Criteria criteria = getSession().createCriteria(Category.class);
		return (List<Category> ) criteria.list();
	}
}