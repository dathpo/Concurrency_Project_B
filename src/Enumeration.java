
public class Enumeration {
	Thread root;
	ThreadGroup[] groups;
	public Enumeration(Thread root){
		this.root = root; 
	}
	
	public ThreadGroup[] createArrayOfGroups(){
		Thread[] allThreads = new Thread[100];
		groups = new ThreadGroup[100];
		root.getThreadGroup().getParent().getParent().enumerate(allThreads);
		//System.out.println(allThreads);
		int j = 0;
		for(int i = 0; i<allThreads.length ; i++){
			if(allThreads[i]!=null){
			//	System.out.println(allThreads[i]);
				groups[j] = allThreads[i].getThreadGroup();
						System.out.println("groups " + groups[j]);
			}
		}
		return groups;			
	}	
}
