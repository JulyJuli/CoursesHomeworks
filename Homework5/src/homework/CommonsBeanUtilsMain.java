package homework;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import homework.task2.Country;
import homework.task2.Inventor;
import homework.task2.Phone;

public class CommonsBeanUtilsMain {

	private static Map testMap;
	private static Country testCountryBean;

	// call simple, index, mapped, and nested properties using the
	// commons-beanutils library

	public static void main(String[] args) {
		prepareData();

		Phone htc = new Phone();

		htc.setModel("One Mini");
		htc.setPrice(100);
		htc.setInventor(new Inventor("Peter Chou"));
		
		List countryManufacturers = new ArrayList<>();

		Country country1 = new Country();
		country1.setName("China");

		Country country2 = new Country();
		country2.setName("America");

		Country country3 = new Country();
		country3.setName("Japan");

		countryManufacturers.add(country1);
		countryManufacturers.add(country2);
		countryManufacturers.add(country3);

		htc.setCountryManufacturers(countryManufacturers);
		try {

			PropertyUtils.setProperty(htc, "price", 100);
			Integer value = (Integer) PropertyUtils.getProperty(htc, "price");

			System.out.println("Example of simple property: " + value);
			System.out.println("Property price ==> " + value);

			Country firstCountry = (Country) PropertyUtils.getIndexedProperty(htc, "countryManufacturers[0]");
			Country thirdCountry = (Country) PropertyUtils.getIndexedProperty(htc, "countryManufacturers[2]");

			System.out.println("\n" + "Example of index property:");
			System.out.println("First Country ==> " + firstCountry.getName());
			System.out.println("Third Country ==> " + thirdCountry.getName());

			// http://www.java2s.com/Code/Java/Apache-Common/GetMappedProperty.htm
			PropertyUtils.setMappedProperty(testCountryBean, "testMap", "C", "Canada");

			System.out.println("\n" + "Example of map property:");
			System.out.println("The value of the 'C' key is ==> " + BeanUtils.getMappedProperty(testCountryBean, "testMap", "C"));
			System.out.println("The value of the 'A' key is ==> " + BeanUtils.getMappedProperty(testCountryBean, "testMap", "A"));

			
			
			System.out.println("\n" + "Example of nested property:");
			
			 String artistName = (String) PropertyUtils.getNestedProperty(htc, "inventor.name");
	            System.out.println("Inventor Name ==> " + artistName);
			
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (InvocationTargetException e) {
			System.out.println(e);
		} catch (NoSuchMethodException e) {
			System.out.println(e);
		}

	}

	private static void prepareData() {
		testMap = new HashMap();
		testMap.put("Ch", "China");
		testMap.put("A", "America");
		testMap.put("U", "Ukraine");

		 testCountryBean = new Country();
		 testCountryBean.setTestMap(testMap);
	}
}
