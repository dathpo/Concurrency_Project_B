
public class GetRoot {
		
	
		ThreadGroup rootGroup = null;
		ThreadGroup currentThread = null;
		
		public ThreadGroup getRootThread(){
	
			ThreadGroup a = new ThreadGroup("G-A");
			ThreadGroup b = new ThreadGroup("G-B");
			ThreadGroup c = new ThreadGroup(a,"G-C");
			
			(new Thread(a, new GroupWorker())).start();
			(new Thread(a, new GroupWorker())).start();
			(new Thread(a, new GroupWorker())).start();
			(new Thread(b, new GroupWorker())).start();
			(new Thread(c, new GroupWorker())).start();
			(new Thread(c, new GroupWorker())).start();
			
			
			currentThread = Thread.currentThread().getThreadGroup();
			
			rootGroup = currentThread.getParent();
			while (rootGroup != null)
			{
				currentThread = rootGroup;
				rootGroup = currentThread.getParent();
			}
			return rootGroup;
		}	
}
