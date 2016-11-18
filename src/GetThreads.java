
public class GetThreads {

		public GetThreads(){
			displayOutput(enumerate(getRoot()));
		}

		
		private ThreadGroup getRoot(){
			ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();
			ThreadGroup rootGroup = currentThreadGroup.getParent();
 			while (currentThreadGroup.getParent()  != null){
	 			rootGroup = currentThreadGroup.getParent();
	 			currentThreadGroup = rootGroup;
			}
 			return rootGroup;
		}
		
		private Thread[] enumerate(ThreadGroup rootGroup){
				Thread[] allThreads = new Thread[rootGroup.activeCount()];
				rootGroup.enumerate(allThreads);
				return allThreads;
		}
		
		private void displayOutput(Thread[] allThreads){
				Display d = new Display(allThreads);
		        }
	}
