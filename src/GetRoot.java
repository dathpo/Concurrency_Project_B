
public class GetRoot {
		
	
		ThreadGroup rootGroup = null;
		ThreadGroup currentThread = null;
		
		public ThreadGroup getRootThread(){
	
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
