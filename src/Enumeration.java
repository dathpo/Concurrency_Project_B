
public class Enumeration {
	Thread root;
	ThreadGroup[] groups;
	public Enumeration(Thread root){
		this.root = root; 
	}
	
	public ThreadGroup[] createArrayOfGroups(){
		Thread[] allThreads = null;
		root.enumerate(allThreads);
		int j = 0;
		for(int i = 0; allThreads.length <1; i++){
			groups[j] = allThreads[i].getThreadGroup();
				if(!allThreads[i].getThreadGroup().equals(allThreads[i].getThreadGroup())){
					j++;
				}
		}
		return groups;	
	}	
}
