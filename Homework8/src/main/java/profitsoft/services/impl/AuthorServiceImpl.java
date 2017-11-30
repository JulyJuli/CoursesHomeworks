package profitsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import profitsoft.beans.Author;
import profitsoft.dao.AuthorDao;
import profitsoft.services.AuthorService;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorDao authorDao;

	public int insertAuthor(Author author) {
		
		return authorDao.insertAuthor(author);
	}

	public boolean updateAuthor(Author author){
		
		return authorDao.updateAuthor(author);
	}

	public Author selectAuthorById(int id) {
		
		return authorDao.selectAuthorById(id);
	}

	public List<Author> selectAllAuthors() {
		
		return authorDao.selectAllAuthors();
	}

	public boolean deleteAuthorById(int id) {
	
		return authorDao.deleteAuthorById(id);
	}

}
