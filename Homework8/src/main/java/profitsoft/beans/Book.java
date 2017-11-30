package profitsoft.beans;

/**
 * The Book class contains description of table Book
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-27
 */
public class Book {

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
	@Override
	public String toString() {
		return "Book ID: " + idBook + "|| Name: " + Name + "|| ISBN:" + ISBN;
	}
	
	
}
