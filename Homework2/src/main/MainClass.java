package main;
import employeePackage.*;

public class MainClass {

	
	public static void main(String[] args) {
	
		Employee dev = new Developer();
		dev.setHoursOfWork(10);
		dev.setRate(500);

		Employee man = new Manager();
		man.setHoursOfWork(90);
		man.setRate(1000);
		
		Accountant a = new Accountant();
		System.out.println(a.getSalaryOfEmployees(man, dev));
	}
	
	
	
	
}
