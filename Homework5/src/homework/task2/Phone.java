package homework.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * The Phone is class that contains fields for demonstrate PropertyUtils and BeanUtils 
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-06
 */
public class Phone {

	private String model;
	private int price;
	private List<Country> countryManufacturers = new ArrayList<Country>();
	private Inventor inventor;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Country> getCountryManufacturers() {
		return countryManufacturers;
	}

	public void setCountryManufacturers(List<Country> countryManufacturers) {
		this.countryManufacturers = countryManufacturers;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Inventor getInventor() {
		return inventor;
	}

	public void setInventor(Inventor inventor) {
		this.inventor = inventor;
	}
}
