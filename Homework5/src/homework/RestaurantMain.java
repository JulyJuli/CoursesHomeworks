package homework;

import java.util.concurrent.Semaphore;

import homework.task1.Cook;
import homework.task1.Waiter;

public class RestaurantMain {

	public static Boolean p = true;
	public static final Semaphore SEMAPHORE = new Semaphore(1);

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Cook());
		Thread t2 = new Thread(new Waiter());

		System.out.println("Welcome to our Restaurant!" +"\n");
		for (int i = 0; i < 10; i++) {

			System.out.println(t.getName() + t.getId() + "\n" + "Let's prepare dishues!........");
			t.run();

			System.out.println("\n" + t2.getName() + t2.getId() + "\n" + "I will deliver it...");
			t2.run();

			System.out.println("---------------------------------------" + "\n");
		}
	}

}
