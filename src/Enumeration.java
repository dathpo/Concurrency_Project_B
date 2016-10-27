import java.util.ArrayList;
import java.util.List;

public class Enumeration {
	ThreadGroup root;
	ThreadGroup[] groups;
	public Enumeration(ThreadGroup root){
		this.root = root; 
	}
	
	public Thread[] createArrayOfGroups(){
		Thread[] allThreads = new Thread[root.activeCount()];
		//Thread[] temp = new Thread[root.activeCount()];
		root.enumerate(allThreads);
		for(int i = 0; i<allThreads.length ; i++){
			if(allThreads[i]!=null){
				System.out.println("non null thread");
			}
		}
		return allThreads;			
	}	
}
