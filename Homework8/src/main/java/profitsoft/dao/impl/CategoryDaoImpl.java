package profitsoft.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import profitsoft.beans.Category;
import profitsoft.dao.CategoryDao;
import utils.Queries;

@Repository
@Qualifier("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Category> selectAllCategories() {
		List<Category> categories = jdbcTemplate.query(Queries.SELECT_ALL_CATEGORIES,
				new BeanPropertyRowMapper<Category>(Category.class));
		return categories;
	}
}