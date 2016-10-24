
public class Enumeration {
	Thread root;
	ThreadGroup[] groups;
	public Enumeration(Thread root){
		this.root = root; 
	}
	
	public ThreadGroup[] createArrayOfGroups(){
		Thread[] allThreads = new Thread[100];
		root.getThreadGroup().enumerate(allThreads);
		System.out.println(allThreads);
		int j = 0;
		for(int i = 0; i<allThreads.length ; i++){
			groups[j] = allThreads[i].getThreadGroup();
				if(!allThreads[i].getThreadGroup().equals(allThreads[i].getThreadGroup())){
					j++;
					System.out.println("groups " + groups[j]);
				}
		}
		
		return groups;	
		
	}	
}
