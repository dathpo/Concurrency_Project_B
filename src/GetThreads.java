public class GetThreads {

	Display d;

	public GetThreads(Display d) {
		this.d = d;
		displayOutput(enumerate(getRoot()));
	}

	private ThreadGroup getRoot() {
		ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();
		ThreadGroup rootGroup = currentThreadGroup; 
		while (rootGroup.getParent() != null) {
			rootGroup = rootGroup.getParent();
		}
		return rootGroup;
	}

	private Thread[] enumerate(ThreadGroup rootGroup) {
		Thread[] allThreads = new Thread[rootGroup.activeCount()];
		rootGroup.enumerate(allThreads);
		return allThreads;
	}

	private void displayOutput(Thread[] allThreads) {
		d.updateTable(allThreads);
	}
}