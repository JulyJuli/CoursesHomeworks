package homework.task1;

import homework.RestaurantMain;

/**
 * The Cook is class that contains logic for "cooking" by thread
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-06
 */

public class Cook implements Runnable {

	@Override
	public void run() {
		try {
			if (RestaurantMain.p) {
				RestaurantMain.SEMAPHORE.acquire();

				System.out.println("Cooking...");
				Thread.sleep(2000);

				RestaurantMain.p = false;
				RestaurantMain.SEMAPHORE.release();
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
