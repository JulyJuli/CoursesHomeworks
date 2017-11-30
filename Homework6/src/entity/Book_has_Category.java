package entity;

public class Book_has_Category {

	//select book.idBook, book.Name, category.Name from book, category, book_has_category 
	//where book.idBook = book_has_category.Book_idBook AND book_has_category.Category_idCategory = category.idCategory;

	private int idBook;
	private String bookName;
	private String categoryName;
	
	
	public String getBooksName() {
		return bookName;
	}
	public void setBooksName(String booksName) {
		this.bookName = booksName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	@Override
	public String toString() {
		return "Book_has_Category [idBook=" + idBook  + ", booksName=" + bookName
				+ ", categoryName=" + categoryName + "]";
	}
	

	
}
