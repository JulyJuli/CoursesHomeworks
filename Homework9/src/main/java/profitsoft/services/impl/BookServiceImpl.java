package profitsoft.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import profitsoft.beans.Author;
import profitsoft.beans.Book;
import profitsoft.beans.Category;
import profitsoft.dao.BookDao;
import profitsoft.services.BookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Transactional
	public int insertBook(Book book) {
		return bookDao.insertBook(book);
	}
	
	@Transactional
	public List<Book> selectBooksByCategoryAndAuthor(String author, String category) {
		return bookDao.selectBooksByCategoryAndAuthor(author, category);
	}
	
	@Transactional
	public int insertBookWithAuthorsAndCategories(Book book, Set<Author> authors, Set<Category> categories){
		return bookDao.insertBookWithAuthorsAndCategories(book, authors, categories);
	}

	@Transactional
	public int insertBookWithAuthors(Book book, Set<Author> authors){
		return bookDao.insertBookWithAuthors(book, authors);
	}
	@Transactional
	public void updateBook(Book book) {
		 bookDao.updateBook(book);
	}

	@Transactional
	public Book selectBookById(int id)  {
		return bookDao.selectBookById(id);
	}

	@Transactional
	public List<Book> selectAllBooks(){
		return bookDao.selectAllBooks();
	}

	@Transactional
	public boolean deleteBookById(int id) {
		return bookDao.deleteBookById(id);
	}
	
	@Transactional
	public List<Book> selectAuthorBook(String author) {
		return bookDao.selectAuthorBook(author);
	}
	
	@Transactional
	public List<Book> selectBooksFromCategory(String category) {
		return bookDao.selectBooksFromCategory(category);
	}


}
