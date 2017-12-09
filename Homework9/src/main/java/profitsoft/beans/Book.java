package profitsoft.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The Book class contains description of table Book
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-27
 */

@Entity
@Table(name="book")
public class Book {

	public Book(){}
	
	@Id
	@Column(name="idBook")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBook;
	private String Name;
	private int ISBN;

	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	
	 
	
	    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinTable(name = "book_author",
	            joinColumns = @JoinColumn(name = "idBook"),
	            inverseJoinColumns = @JoinColumn(name = "idAuthor"))
	    private Set<Author> authors = new HashSet<>();
	    
	    public Set<Author> getAuthors () {
	        return authors;
	    }

	    public void setAuthors(Set<Author> authors) {
	        this.authors = authors;
	    }

	    public void addAuthor(Author author) {
	        authors.add(author);
	    }
	
	    
	    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinTable(name = "book_category",
	            joinColumns = @JoinColumn(name = "idBook"),
	            inverseJoinColumns = @JoinColumn(name = "idCategory"))
	    private Set<Category> categories = new HashSet<>();
	    
	    public Set<Category> getCategories () {
	        return categories;
	    }

	    public void setCategories(Set<Category> categories) {
	        this.categories= categories;
	    }

	    public void addCategory(Category category) {
	    	categories.add(category);
	    }
	
	    
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Book)) {
			return false;
		}

		Book book = (Book) o;

		return book.Name == Name && book.idBook == idBook && book.ISBN==ISBN;
	}

	// Idea from effective Java : Item 9
	@Override
	public int hashCode() {
		int result = 17;
	
		result = 31 * result + idBook;
		result = 31 * result + ((Name == null) ? 0 : Name.hashCode());
		result = 31 * result + ((ISBN == 0) ? 0 : ISBN);
		return result;
	}

	
	
	@Override
	public String toString() {
		return "Book ID: " + idBook + "|| Name: " + Name + "|| ISBN:" + ISBN + "\n";
	}
	
	
}
