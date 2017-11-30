package employeePackage;

/**
 * That is a child class of Employee
 * 
 * @author Yuliia Nechyporuk
 */

public class Developer extends Employee {

	/**
	 * Method count month salary for Developer result depends on total working
	 * hours for month
	 * 
	 * @return month salary
	 * 
	 */

	@Override
	public float getFullSalary() {
		int workingHours = super.getHoursOfWork();
		int rate = super.getRate();
		if (workingHours <= 0 || rate < 0)
			return 0;
		return workingHours * rate / STANDART_HOURS_OF_WORK;

	}

}
