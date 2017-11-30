package employeePackage;

/***
 * That is an abstract parent class
 ** 
 * @author Yuliia Nechyporuk
 */

public abstract class Employee {

	public static final int STANDART_HOURS_OF_WORK = 100;

	private int rate, hoursOfWork;

	/**
	 * Method count percent of working hours for a month
	 * 
	 * @return percent of working hours or 0 if hoursOfWork less or equal 0
	 * 
	 */

	public float getPercent() {
		if (hoursOfWork <= 0)
			return 0;
		return getHoursOfWork() * 100 / STANDART_HOURS_OF_WORK;
	};

	public abstract float getFullSalary();

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getHoursOfWork() {
		return hoursOfWork;
	}

	public void setHoursOfWork(int hoursOfWork) {
		this.hoursOfWork = hoursOfWork;
	}

}
