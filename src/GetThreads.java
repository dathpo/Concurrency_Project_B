/**
 * This class is used to get all the threads in the system and pass this
 * information to the display allowing it to be updated.
 * 
 * @author Group B
 *
 */

public class GetThreads {
	Display d;

	public GetThreads(Display d) {
		this.d = d;

		// call getRoot and pass its output in to enumerate, the output of which
		// is then passed to displayOutput
		displayOutput(enumerate(getRoot()));
	}

	/**
	 * This method gets the root of the running threads. Should always be the
	 * system ThreadGroup. Done by checking the parent group above is not null,
	 * if true then this parent group becomes the new root and its parent is
	 * checked, and so on.
	 * 
	 * @return the top ThreadGroup of the tree structure of active threads.
	 */
	private ThreadGroup getRoot() {
		ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();
		ThreadGroup rootGroup = currentThreadGroup;
		while (rootGroup.getParent() != null) {
			rootGroup = rootGroup.getParent();
		}
		return rootGroup;
	}

	/**
	 * This method is merely the creation of an Array with enough space to hold
	 * all the threads and then a call to enumerate which fills said Array with
	 * every thread.
	 * 
	 * @param rootGroup
	 *            The basal ThreadGroup
	 * @return an Array of all the Threads running in the application.
	 */
	private Thread[] enumerate(ThreadGroup rootGroup) {
		Thread[] allThreads = new Thread[rootGroup.activeCount()];
		rootGroup.enumerate(allThreads);
		return allThreads;
	}

	/**
	 * This method is a call on the display to updateTable with the most
	 * recently got Array of all the Threads
	 * 
	 * @param allThreads
	 *            Every thread running in the application
	 */
	private void displayOutput(Thread[] allThreads) {
		d.updateOutput(allThreads);
	}
}