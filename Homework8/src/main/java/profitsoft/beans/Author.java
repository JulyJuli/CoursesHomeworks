package profitsoft.beans;

/**
 * The Author class contains description of table Author
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-27
 */
public class Author {

	private int idAuthor;
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
	
	@Override
	public String toString() {
		return "Author ID: " + idAuthor + " || Name: " + Name + "\n" ;
	}
}
