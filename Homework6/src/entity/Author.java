package entity;

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
