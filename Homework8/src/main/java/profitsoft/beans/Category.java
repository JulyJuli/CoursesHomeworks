package profitsoft.beans;

/**
 * The Category class contains description of table Category
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-27
 */
public class Category {

	
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
	@Override
	public String toString() {
		return "Category ID: " + idCategory + "|| Name: " + Name;
	}
	
	
}
