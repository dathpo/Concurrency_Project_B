/**
 * This class allows the behaviour of threads created in CGAT class to be
 * altered.
 * 
 * @author Group B
 *
 */
public class RunnableTest implements Runnable {

	/**
	 * This is the default method for any class implementing the Runnable
	 * interface and simply sends the thread into TIMED_WAITING.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				for (int i = 0; i > 1000000; i++)
					;
			} catch (InterruptedException ie) {

			}
		}

	}

}