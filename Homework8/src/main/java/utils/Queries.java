package utils;

public class Queries {

	public static final String SELECT_ALL_BOOKS = "SELECT * FROM book";
	public static final String SELECT_ALL_AUTHORS = "SELECT * FROM author";
	public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM test.category";
	
	
	public static final String SELECT_BOOKS_WITH_AUTHORS_AND_CATEGORIES = "select idBook, book.Name , author.Name, category.Name"
			+ " from book " + "inner join book_has_author on idBook = book_has_author.Book_idBook "
			+ "inner join author on book_has_author.Author_idAuthor = author.idAuthor "
			+ "inner join book_has_category on idBook = book_has_category.Book_idBook "
			+ "inner join category on book_has_category.Category_idCategory = category.idCategory";
	
	public static final String SELECT_BOOK_BY_ID = "SELECT * FROM book where idBook=?";
	public static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM author where idAuthor=?";

	
	public static final String SELECT_BOOKS_WITH_AUTHORS_AND_CATEGORIES_BY_AUTHOR = "select idBook, book.Name , author.Name, category.Name"
			+ " from book " + "inner join book_has_author on idBook = book_has_author.Book_idBook "
			+ "inner join author on book_has_author.Author_idAuthor = author.idAuthor "
			+ "inner join book_has_category on idBook = book_has_category.Book_idBook "
			+ "inner join category on book_has_category.Category_idCategory = category.idCategory "
			+ "where author.Name=?";

	public static final String DELETE_BOOK_BY_ID = "DELETE FROM book WHERE idBook=?;";
	public static final String INSERT_INTO_BOOK_TABLE = "INSERT INTO book VALUES (DEFAULT,?,?);";
	public static final String UPDATE_BOOK_TABLE = "UPDATE book SET Name=?, ISBN=? WHERE idBook=?;";
	
	public static final String DELETE_AUTHOR_BY_ID = "DELETE FROM author WHERE idAuthor=?;";
	public static final String INSERT_INTO_AUTHOR_TABLE = "INSERT INTO author VALUES (DEFAULT,?);";
	public static final String UPDATE_AUTHOR_TABLE = "UPDATE author SET Name=? WHERE idAuthor=?;";
	
}

