package profitsoft.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import profitsoft.beans.Author;
import profitsoft.dao.AuthorDao;
import utils.Queries;

@Repository
@Qualifier("authorDao")
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(BookDaoImpl.class.getName());

	public int insertAuthor(Author author) {
		
	      KeyHolder keyHolder = new GeneratedKeyHolder();

	      jdbcTemplate.update(
	              connection -> {
	                  PreparedStatement pst = connection.prepareStatement(Queries.INSERT_INTO_AUTHOR_TABLE, new String[]{"Id"});
	                  pst.setString(1, author.getName());
	                  return pst;
	              }, keyHolder);

	      Number key = keyHolder.getKey();    
	      return key.intValue();
	}

	public boolean updateAuthor(Author author) {
		boolean result;

		if (jdbcTemplate.update(Queries.UPDATE_AUTHOR_TABLE, author.getName(), author.getIdAuthor()) == 1) {
			result = true;
		} else
			result = false;

		return result;
	}

	public Author selectAuthorById(int id) {
		Author author = null;
		try {
			author = (Author) jdbcTemplate.queryForObject(Queries.SELECT_AUTHOR_BY_ID, new Object[] { id },
					new BeanPropertyRowMapper<Author>(Author.class));
		} catch (InvalidResultSetAccessException e) {
			log.info("Data unavailable");
		} catch (DataAccessException e) {
			log.info("Data unavailable");
		}
		return author;
	}

	public List<Author> selectAllAuthors() {

		List<Author> authors = jdbcTemplate.query(Queries.SELECT_ALL_AUTHORS,
				new BeanPropertyRowMapper<Author>(Author.class));

		return authors;
	}

	public boolean deleteAuthorById(int id) {
		boolean result;
		if (jdbcTemplate.update(Queries.DELETE_AUTHOR_BY_ID, id) == 1) {
			result = true;
		} else
			result = false;

		return result;
	}

}
