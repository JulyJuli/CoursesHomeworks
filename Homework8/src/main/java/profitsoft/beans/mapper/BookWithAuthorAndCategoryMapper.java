package profitsoft.beans.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import profitsoft.beans.BookWithAuthorAndCategory;

/**
 * The BookWithAuthorAndCategoryMapper class implements own logic of RowMapper
 * interface
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-27
 */
public class BookWithAuthorAndCategoryMapper implements RowMapper<BookWithAuthorAndCategory> {

	public BookWithAuthorAndCategory mapRow(ResultSet rs, int rownumber) throws SQLException {
		BookWithAuthorAndCategory book = new BookWithAuthorAndCategory();

		book.setIdBook(rs.getInt("idBook"));
		book.setBookName(rs.getString("Name"));
		book.setBookAuthor(rs.getString("author.Name"));
		book.setBookCategory(rs.getString("category.Name"));
		return book;
	}

}