
public class DisplayThreads {

		
		public ThreadGroup getRoot(){
			ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();
			ThreadGroup rootGroup = currentThreadGroup.getParent();
 			while (currentThreadGroup.getParent()  != null)
 			{
 			rootGroup = currentThreadGroup.getParent();
 			currentThreadGroup = rootGroup;
			}
				return rootGroup;
		}
		
		public Thread[] enumerate(ThreadGroup rootGroup){
				Thread[] allThreads = new Thread[rootGroup.activeCount()];
				rootGroup.enumerate(allThreads);
				return allThreads;
		}
		
		public void displayOutput(Thread[] allThreads){
				int i =0;
				String groupName = "";
		        while ( i< allThreads.length) {
		               if(!groupName.equals(allThreads[i].getThreadGroup().getName())){
		                     groupName = allThreads[i].getThreadGroup().getName();
		                     System.out.println(allThreads[i].getThreadGroup().getName());
		               }
		 //System.out.println("Name : " + threads[i].getName() + ",  ID : "+ threads[i].getId()  +",  State : " + threads[i].getState() + ",  IS Demon :"+ threads[i].isDaemon() );
		 System.out.println("	Name : " + allThreads[i].getName() + ",  ID : "+ allThreads[i].getId()  +",  State : " + allThreads[i].getState() + ",  IS Daemon :"+ allThreads[i].isDaemon() );
		  i++;
		        }
		}
}
