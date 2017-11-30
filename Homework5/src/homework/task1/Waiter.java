package homework.task1;

import homework.RestaurantMain;

/**
 * The Waiter is class that contains logic for delivering dish cooked by other thread
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-06
 */
public class Waiter implements Runnable {

	@Override
	public void run() {
		try {
			RestaurantMain.SEMAPHORE.acquire();
			Thread.sleep(500);
			System.out.println("Client got dish!");

			RestaurantMain.p = true;
			RestaurantMain.SEMAPHORE.release();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
