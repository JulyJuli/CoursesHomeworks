package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Author;
import entity.Book;
import entity.Book_has_Author;
import entity.Book_has_Author_And_Category;
import entity.Book_has_Category;
import entity.Category;

public class Db_Manager {

	// SELECT OPERATIONS FOR BOOK TABLE

	public List<Book> selectAllBooks() throws SQLException {
		List<Book> books = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			books = new ArrayList<Book>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Queries.SELECT_ALL_BOOKS);

			while (rs.next()) {
				Book tmp = new Book();
				tmp.setIdBook(rs.getInt("idBook"));
				tmp.setName(rs.getString("Name"));
				tmp.setISBN(rs.getInt("ISBN"));

				books.add(tmp);
			}

			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return books;
	}


	public List<Author> selectAllAuthors() throws SQLException {
		List<Author> authors = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			authors = new ArrayList<Author>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Queries.SELECT_ALL_AUTHORS);

			while (rs.next()) {
				Author tmp = new Author();
				tmp.setIdAuthor(rs.getInt("idAuthor"));
				tmp.setName(rs.getString("Name"));
				authors.add(tmp);
			}

			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return authors;
	}

	public List<Category> selectAllCategories() throws SQLException {
		List<Category> categories = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			categories = new ArrayList<Category>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Queries.SELECT_ALL_CATEGORIES);

			while (rs.next()) {
				Category tmp = new Category();
				tmp.setIdCategory(rs.getInt("idCategory"));
				tmp.setName(rs.getString("Name"));

				categories.add(tmp);
			}

			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return categories;
	}

	public List<Book_has_Category> selectBookWithCategory() throws SQLException {
		List<Book_has_Category> books = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			books = new ArrayList<Book_has_Category>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Queries.SELECT_ALL_BOOKS_WITH_CATEGORIES);

			while (rs.next()) {
				Book_has_Category tmp = new Book_has_Category();
				tmp.setIdBook(rs.getInt("book.idBook"));
				tmp.setBooksName(rs.getString("book.Name"));
				tmp.setCategoryName(rs.getString("category.Name"));

				books.add(tmp);
			}

			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return books;
	}

	public List<Book_has_Author> selectBookWithAuthor() throws SQLException {
		List<Book_has_Author> books = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			books = new ArrayList<Book_has_Author>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Queries.SELECT_ALL_BOOKS_WITH_AUTHORS);

			while (rs.next()) {
				Book_has_Author tmp = new Book_has_Author();
				tmp.setIdBook(rs.getInt("book.idBook"));
				tmp.setBookName(rs.getString("book.Name"));
				tmp.setISBN(rs.getInt("book.ISBN"));
				tmp.setBookAuthor(rs.getString("author.Name"));

				books.add(tmp);
			}

			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return books;
	}

	public List<Book_has_Author_And_Category> selectBookWithAuthorAndCategory() throws SQLException {
		List<Book_has_Author_And_Category> books = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			books = new ArrayList<Book_has_Author_And_Category>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Queries.SELECT_BOOKS_WITH_AUTHORS_AND_CATEGORIES);

			while (rs.next()) {
				Book_has_Author_And_Category tmp = new Book_has_Author_And_Category();
				tmp.setIdBook(rs.getInt("book.idBook"));
				tmp.setBookName(rs.getString("book.Name"));
				tmp.setBookAuthor(rs.getString("author.Name"));
				tmp.setBookCategory(rs.getString("category.Name"));

				books.add(tmp);
			}

			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return books;
	}

	public Author selectAuthorById(int id) throws SQLException {
		Author author = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			author = new Author();
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.SELECT_AUTHOR_BY_ID);

			try {

				pst.setInt(1, id);

				rs = pst.executeQuery();
				if (rs.next()) {
					author.setIdAuthor(rs.getInt("idAuthor"));
					author.setName(rs.getString("Name"));
				}

			} finally {
				if (pst != null) {
					pst.close();
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return author;
	}

	public Book selectBookById(int id) throws SQLException {
		Book book = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			book = new Book();
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.SELECT_BOOK_BY_ID);

			try {

				pst.setInt(1, id);

				rs = pst.executeQuery();
				if (rs.next()) {
					book.setIdBook(rs.getInt("idBook"));
					book.setName(rs.getString("Name"));
					book.setISBN(rs.getInt("ISBN"));
				}

			} finally {
				if (pst != null) {
					pst.close();
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}

	public List<Book_has_Author_And_Category> selectBookWithAuthorAndCathegoryByAuthorAndCategory(String author,
			String category) throws SQLException {
		List<Book_has_Author_And_Category> book = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			book = new ArrayList<Book_has_Author_And_Category>();
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.SELECT_BOOKS_WITH_AUTHORS_AND_CATEGORIES_BY_AUTHOR_AND_CATEGORY);

			try {

				int i =0;
				pst.setString(++i, author);
				pst.setString(++i, category);

				rs = pst.executeQuery();
				while (rs.next()) {
					Book_has_Author_And_Category tmp = new Book_has_Author_And_Category();
					tmp.setIdBook(rs.getInt("book.idBook"));
					tmp.setBookName(rs.getString("book.Name"));
					tmp.setBookAuthor(rs.getString("author.Name"));
					tmp.setBookCategory(rs.getString("category.Name"));
					book.add(tmp);
				}

			} finally {
				if (pst != null) {
					pst.close();
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}

	public List<Book_has_Author_And_Category> selectBookWithAuthorAndCathegoryById(int id) throws SQLException {
		List<Book_has_Author_And_Category> book = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			book = new ArrayList<Book_has_Author_And_Category>();
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.SELECT_BOOKS_WITH_AUTHORS_AND_CATEGORIES_BY_ID);

			try {

				pst.setInt(1, id);

				rs = pst.executeQuery();
				while (rs.next()) {
					Book_has_Author_And_Category tmp = new Book_has_Author_And_Category();
					tmp.setIdBook(rs.getInt("book.idBook"));
					tmp.setBookName(rs.getString("book.Name"));
					tmp.setBookAuthor(rs.getString("author.Name"));
					tmp.setBookCategory(rs.getString("category.Name"));
					book.add(tmp);
				}

			} finally {
				if (pst != null) {
					pst.close();
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}

	// DELETE UPDATE INSERT OPERATIONS FOR BOOK TABLE

	public boolean deleteBookById(int id) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			try {
				con = ConnectionFactory.getMySQlConnection();
				pst = con.prepareStatement(Queries.DELETE_BOOK_BY_ID);
				pst.setInt(1, id);
				pst.execute();

				result = true;
			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int insertBook(Book book) throws SQLException {

		int generatedId = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.INSERT_INTO_BOOK_TABLE, 1);

			try {
				int i = 0;

				pst.setString(++i, book.getName());
				pst.setInt(++i, book.getISBN());

				if (pst.executeUpdate() > 0 && (rs = pst.getGeneratedKeys()).next()) {
					generatedId = rs.getInt(1);
					book.setIdBook((int) generatedId);

				}

			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return generatedId;
	}

	public boolean updateBook(Book book) throws SQLException {
		boolean result = false;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.UPDATE_BOOK_TABLE);

			try {
				int i = 0;
				pst.setString(++i, book.getName());
				pst.setInt(++i, book.getISBN());
				pst.setInt(++i, book.getIdBook());

				pst.executeUpdate();
				result = true;
			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// DELETE UPDATE INSERT OPERATIONS FOR AUTHOR TABLE

	public boolean deleteAuthorById(int id) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			try {
				con = ConnectionFactory.getMySQlConnection();
				pst = con.prepareStatement(Queries.DELETE_AUTHOR_BY_ID);
				pst.setInt(1, id);
				pst.execute();

				result = true;
			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int insertAuthor(Author author) throws SQLException {

		int generatedId = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.INSERT_INTO_AUTHOR_TABLE, 1);

			try {
				int i = 0;

				pst.setString(++i, author.getName());

				if (pst.executeUpdate() > 0 && (rs = pst.getGeneratedKeys()).next()) {
					generatedId = rs.getInt(1);
					author.setIdAuthor(generatedId);

				}

			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return generatedId;
	}

	public boolean updateAuthor(Author author) throws SQLException {
		boolean result = false;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.UPDATE_AUTHOR_TABLE);

			try {
				int i = 0;
				pst.setString(++i, author.getName());
				pst.setInt(++i, author.getIdAuthor());

				pst.executeUpdate();
				result = true;
			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// UPDATE INSERT OPERATIONS FOR BOOK_HAS_AUTHOR TABLE

	public boolean deleteFromBookHasAuthor(int idBook) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			try {
				con = ConnectionFactory.getMySQlConnection();
				pst = con.prepareStatement(Queries.DELETE_FROM_BOOK_HAS_AUTHOR);
				pst.setInt(1, idBook);
				pst.execute();

				result = true;
			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public boolean insertBookHasAuthor(Book_has_Author book) throws SQLException {
		boolean result = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.INSERT_INTO_BOOK_HAS_AUTHOR_TABLE);

			try {
				int i = 0;

				pst.setInt(++i, book.getIdBook());
				pst.setInt(++i, book.getIdAuthor());

				pst.executeUpdate();
				result = true;

			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public boolean updateBookHasAuthor_idAuthor(Book_has_Author book, int newIdAuthor) throws SQLException {
		boolean result = false;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionFactory.getMySQlConnection();
			pst = con.prepareStatement(Queries.UPDATE_BOOK_HAS_AUTHOR_TABLE);

			try {
				int i = 0;
				pst.setInt(++i, newIdAuthor);
				pst.setInt(++i, book.getIdBook());
				pst.setInt(++i, book.getIdAuthor());

				pst.executeUpdate();
				result = true;
			} finally {
				if (pst != null) {
					pst.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
