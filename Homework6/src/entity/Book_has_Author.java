package entity;

public class Book_has_Author {

	private int idBook;
	private int idAuthor;
	private String bookName;
	private int ISBN;
	private String bookAuthor;
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	
	@Override
	public String toString() {
		return "Book ID: " + idBook + "|| Name:" + bookName + "|| ISBN: "
				+ ISBN + "|| Author: " + bookAuthor+"\n";
	}
	public int getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	
	
}
