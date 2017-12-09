package profitsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import profitsoft.beans.Author;
import profitsoft.dao.AuthorDao;
import profitsoft.services.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorDao authorDao;
	
	@Transactional
	public int insertAuthor(Author author) {
		
		return authorDao.insertAuthor(author);
	}
	
	@Transactional
	public void updateAuthor(Author author){
		authorDao.updateAuthor(author);
	}
	
	@Transactional
	public Author selectAuthorById(int id) {
		
		return authorDao.selectAuthorById(id);
	}

	@Transactional
	public List<Author> selectAllAuthors() {
		
		return authorDao.selectAllAuthors();
	}

	@Transactional
	public boolean deleteAuthorById(int id) {
	
		return authorDao.deleteAuthorById(id);
	}

}
