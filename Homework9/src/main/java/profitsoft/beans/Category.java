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
 * The Category class contains description of table Category
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-27
 */
@Entity
@Table(name="Category")
public class Category {

	public Category() { } 
	
	
	@Id
	@Column(name="idCategory")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCategory;
	private String Name;
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	

	@ManyToMany(mappedBy="categories")
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
		if (!(o instanceof Category)) {
			return false;
		}

		Category category = (Category) o;

		return category.Name == Name && category.idCategory == idCategory;
	}

	// Idea from effective Java : Item 9
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + idCategory;
		result = 31 * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Category ID: " + idCategory + "|| Name: " + Name;
	}
	
	
}
