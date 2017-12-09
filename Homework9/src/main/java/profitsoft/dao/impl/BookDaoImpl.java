package profitsoft.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import profitsoft.beans.Author;
import profitsoft.beans.Book;
import profitsoft.beans.Category;
import profitsoft.dao.AbstractDao;
import profitsoft.dao.BookDao;
import utils.Queries;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDao implements BookDao {

	public int insertBook(Book book) {

		save(book);
		return book.getIdBook();
	}

	public void updateBook(Book book) {
		getSession().update(book);
	}

	public Book selectBookById(int id) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.eq("idBook", id));
		return (Book) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Book> selectAllBooks() {
		Criteria criteria = getSession().createCriteria(Book.class);
		return (List<Book>) criteria.list();
	}

	public boolean deleteBookById(int id) {
		Query query = getSession().createSQLQuery(Queries.DELETE_BOOK_BY_ID);
		query.setInteger("idBook", id);
		int result = query.executeUpdate();
		return result==1?true:false;
	}

	@Transactional
	public List<Book> selectBooksByCategoryAndAuthor(String author, String category) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.createAlias("categories", "c").add(Restrictions.eq("c.Name", category));
		criteria.createAlias("authors", "a").add(Restrictions.eq("a.Name", author));
		@SuppressWarnings("unchecked")
		List<Book> results = criteria.list();
		return results;

	}

	public List<Book> selectBooksFromCategory(String category) {
		@SuppressWarnings("unchecked")
		List<Book> results = getSession().createCriteria(Book.class).createAlias("categories", "c")
				.add(Restrictions.eq("c.Name", category)).list();
		return results;

	}

	public List<Book> selectAuthorBook(String author) {

		@SuppressWarnings("unchecked")
		List<Book> results = getSession().createCriteria(Book.class).createAlias("authors", "a")
				.add(Restrictions.eq("a.Name", author)).list();
		return results;

	}

	public int insertBookWithAuthorsAndCategories(Book book, Set<Author> authors, Set<Category> categories) {

		book.getAuthors().addAll(authors);

		book.getCategories().addAll(categories);
		saveOrUpdate(book);
		return book.getIdBook();
	}

	public int insertBookWithAuthors(Book book, Set<Author> authors) {

		book.getAuthors().addAll(authors);
		saveOrUpdate(book);
		return book.getIdBook();
	}

}
