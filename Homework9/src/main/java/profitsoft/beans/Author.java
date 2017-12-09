package profitsoft.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Author class contains description of table Author
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-27
 */
@Entity
@Table(name="Author")
public class Author {

	public Author() { } 
	

	@Id
	@Column(name="idAuthor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAuthor;
	
	@Column(name="Name")
	private String Name;
	
	public int getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	

	@ManyToMany(mappedBy="authors")
	private Set<Book> bookSet = new HashSet<>();	 
	    
	    public Set<Book> getBookSet() {
	        return bookSet;
	    }

	    public void setBookSet(Set<Book> bookSet) {
	        this.bookSet = bookSet;
	    }

	
	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Author)) {
			return false;
		}

		Author author = (Author) o;

		return author.Name == Name && author.idAuthor == idAuthor;
	}

	// Idea from effective Java : Item 9
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + idAuthor;
		result = 31 * result + ((Name == null) ? 0 : Name.hashCode());
		
		return result;
	}

	
	@Override
	public String toString() {
		return "Author ID: " + idAuthor + " || Name: " + Name + "\n" ;
	}

}
