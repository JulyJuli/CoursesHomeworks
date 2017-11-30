package profitsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import profitsoft.beans.Book;
import profitsoft.beans.BookWithAuthorAndCategory;
import profitsoft.dao.BookDao;
import profitsoft.services.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	public int insertBook(Book book) {
		return bookDao.insertBook(book);
	}

	public boolean updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	public Book selectBookById(int id)  {
		return bookDao.selectBookById(id);
	}

	public List<Book> selectAllBooks(){
		return bookDao.selectAllBooks();
	}

	public boolean deleteBookById(int id) {
		return bookDao.deleteBookById(id);
	}
	
	public List<BookWithAuthorAndCategory> selectAllBooksWithCategoryAndAuthor() {
		return bookDao.selectAllBooksWithCategoryAndAuthor();
	}
	public List<BookWithAuthorAndCategory> selectAllAuthorsBooks(String author) {
		return bookDao.selectAllAuthorsBooks(author);
	}


}
