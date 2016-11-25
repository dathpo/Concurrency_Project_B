public class CreateGroupsAndThreads {
	
	public CreateGroupsAndThreads(){
		ThreadGroup a = new ThreadGroup("G-A");
		ThreadGroup b = new ThreadGroup(a,"G-B");
		ThreadGroup c = new ThreadGroup(b,"G-C");
		
		(new Thread(a, new RunnableTest())).start();
		(new Thread(a, new RunnableTest())).start();
		(new Thread(a, new RunnableTest())).start();
		(new Thread(b, new RunnableTest())).start();
		(new Thread(c, new RunnableTest())).start();
		(new Thread(c, new RunnableTest())).start();
		
	}
	
}
