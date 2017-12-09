package profitsoft.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import profitsoft.beans.Author;
import profitsoft.dao.AbstractDao;
import profitsoft.dao.AuthorDao;
import utils.Queries;

@Repository("authorDao")
public class AuthorDaoImpl extends AbstractDao implements AuthorDao {
	
	public int insertAuthor(Author author) {

		save(author);
		return author.getIdAuthor();
	}

	public void updateAuthor(Author author) {
		getSession().update(author);
	}


	public Author selectAuthorById(int id) {
		Criteria criteria = getSession().createCriteria(Author.class);
		criteria.add(Restrictions.eq("idAuthor",id));
		return (Author) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Author> selectAllAuthors() {
		Criteria criteria = getSession().createCriteria(Author.class);
		return (List<Author> ) criteria.list();
	}

	public boolean deleteAuthorById(int id) {		
		Query query = getSession().createSQLQuery(Queries.DELETE_AUTHOR_BY_ID);
		query.setInteger("idAuthor", id);
		int result=query.executeUpdate();
		return result==1?true:false;
	}

}
