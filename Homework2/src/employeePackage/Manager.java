package employeePackage;

/**
 * That is a child class of Employee
 * 
 * @author Yuliia Nechyporuk
 */

public class Manager extends Employee {

	/**
	 * Method count month salary for Manager result depends on percent of
	 * working hours for a month
	 * 
	 * @return month salary or 0 if rate less or equal 0
	 * 
	 */
	@Override
	public float getFullSalary() {
	
		float percent = super.getPercent();
		float rate = super.getRate();

		if (rate <= 0)
			return 0;
		if (percent > 100)
			return super.getRate();
		return rate * percent / 100;

	}

}
