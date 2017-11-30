package entity;

public class Book_has_Author_And_Category {

	
	private int idBook;
	private String bookName;
	private String bookAuthor;
	private String bookCategory;
	
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
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
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	@Override
	public String toString() {
		return "Book ID: " + idBook + " || Name: " + bookName + " || Author: "
				+ bookAuthor + " || Category: " + bookCategory;
	}
	
	
	
}
