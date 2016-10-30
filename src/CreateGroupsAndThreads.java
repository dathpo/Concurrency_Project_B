public class CreateGroupsAndThreads {
	public CreateGroupsAndThreads()
	{
		ThreadGroup a = new ThreadGroup("G-A");
		ThreadGroup b = new ThreadGroup("G-B");
		ThreadGroup c = new ThreadGroup(a,"G-C");
		
		(new Thread(a, new RunnableTest())).start();
		(new Thread(a, new RunnableTest())).start();
		(new Thread(a, new RunnableTest())).start();
		(new Thread(b, new RunnableTest())).start();
		(new Thread(c, new RunnableTest())).start();
		(new Thread(c, new RunnableTest())).start();
		

//		ThreadGroup rootThreadGroup = Thread.currentThread( ).getThreadGroup( );
//		ThreadGroup parentGroup;
//		while ( ( parentGroup = rootThreadGroup.getParent() ) != null ) {
//			rootThreadGroup = parentGroup;		   
//		}
//		
//		Thread[] threads = new Thread[rootThreadGroup.activeCount()];
 //       rootThreadGroup.enumerate( threads, true );
  //      int i=0;   
 //        String groupName ="";
		
	}
}
