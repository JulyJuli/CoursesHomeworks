package homework.task2;

import java.util.Map;

/**
 * The Ñountry is class that contains fields for demonstrate PropertyUtils and BeanUtils 
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-06
 */
public class Country {
	
	private String name;
	private Map testMap;

	public Country(){
		
	}
	
	public Map getTestMap() {
		return this.testMap;
	}

	public void setTestMap(Map testMap) {
		this.testMap = testMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
