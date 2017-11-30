package employeePackage;

/**
 * This class is intended for counting salary for different groups of employees
 * 
 * @author Yuliia Nechyporuk
 */

public class Accountant {

	private float totalSalary;

	/**
	 * Method count month salary for employees
	 * 
	 * @param employees
	 *            - array of employees which salary is counted
	 * 
	 * @return  - total salary for array of employees or 0 for empty input data
	 * 
	 */

	public float getSalaryOfEmployees(Employee... employees) {
		if (employees.length == 0) {
			return 0;
		}
		for (Employee e : employees) {

			totalSalary += e.getFullSalary();

		}
		return totalSalary;
	}

}
