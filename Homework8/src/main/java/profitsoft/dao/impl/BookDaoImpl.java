package profitsoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import profitsoft.beans.Book;
import profitsoft.beans.BookWithAuthorAndCategory;
import profitsoft.beans.mapper.BookWithAuthorAndCategoryMapper;
import profitsoft.dao.BookDao;
import utils.Queries;

@Repository
@Qualifier("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate namedJdbcTemplate;
	static Logger log = Logger.getLogger(BookDaoImpl.class.getName());

	public int insertBook(Book book) {
		Connection connection = null;
		PreparedStatement pst = null;
		Integer generatedId = null;

		try {
			connection = jdbcTemplate.getDataSource().getConnection();
			pst = connection.prepareStatement(Queries.INSERT_INTO_BOOK_TABLE, Statement.RETURN_GENERATED_KEYS);
			int i = 0;

			pst.setString(++i, book.getName());
			pst.setInt(++i, book.getISBN());

			pst.executeUpdate();
			ResultSet keys = pst.getGeneratedKeys();

			if (keys.next()) {
				generatedId = keys.getInt(1);
			}
			keys.close();
		} catch (SQLException e) {
			 log.info(e.toString());
		}

		finally {
			if (pst != null || connection != null) {
				try {
					pst.close();
					connection.close();
				} catch (SQLException e) {
					 log.info(e.toString());
				}
			}
		}

		return generatedId;
	}

	public boolean updateBook(Book book) {
		boolean result;

		if (jdbcTemplate.update(Queries.UPDATE_BOOK_TABLE, book.getName(), book.getISBN(), book.getIdBook()) == 1) {
			result = true;
		} else
			result = false;

		return result;
	}

	public Book selectBookById(int id) {
		
		Book book = null;
		try {
			book = (Book) jdbcTemplate.queryForObject(Queries.SELECT_BOOK_BY_ID, new Object[] { id },
					new BeanPropertyRowMapper<Book>(Book.class));
		} catch (InvalidResultSetAccessException e) {
			 log.info("Data not found");
		} catch (DataAccessException e) {
			log.info("Data unavailable");
		}
	
		return book;
	}

	public List<Book> selectAllBooks() {
		List<Book> books= jdbcTemplate.query(Queries.SELECT_ALL_BOOKS, new BeanPropertyRowMapper<Book>(Book.class));
		return books;
	}

	public boolean deleteBookById(int id) {
		boolean result;
		if (jdbcTemplate.update(Queries.DELETE_BOOK_BY_ID, id) == 1) {
			result = true;
		} else
			result = false;

		return result;

	}

	public List<BookWithAuthorAndCategory> selectAllBooksWithCategoryAndAuthor() {

		List<BookWithAuthorAndCategory> books = jdbcTemplate.query(Queries.SELECT_BOOKS_WITH_AUTHORS_AND_CATEGORIES,
				new BookWithAuthorAndCategoryMapper());

		return books;
	}

	public List<BookWithAuthorAndCategory> selectAllAuthorsBooks(String author) {

		List<BookWithAuthorAndCategory> books = jdbcTemplate.query(
				Queries.SELECT_BOOKS_WITH_AUTHORS_AND_CATEGORIES_BY_AUTHOR, new BookWithAuthorAndCategoryMapper(),
				author);

		return books;
	}
	
}
