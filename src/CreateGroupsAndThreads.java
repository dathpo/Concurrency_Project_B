/**
 * This class creates the ThreadGroups and the threads, is very useful for
 * testing purposes.
 * 
 * @author Group B
 */
public class CreateGroupsAndThreads {

	public CreateGroupsAndThreads() {
		// three ThreadGroups created with A being the parent of b and, b being
		// the parent of c.
		ThreadGroup a = new ThreadGroup("G-A");
		ThreadGroup b = new ThreadGroup(a, "G-B");
		ThreadGroup c = new ThreadGroup(b, "G-C");

		// 3 threads added to group a, 1 to b and 2 to c
		(new Thread(a, new RunnableTest())).start();
		(new Thread(a, new RunnableTest())).start();
		(new Thread(a, new RunnableTest())).start();
		(new Thread(b, new RunnableTest())).start();
		(new Thread(c, new RunnableTest())).start();
		(new Thread(c, new RunnableTest())).start();

	}

}
