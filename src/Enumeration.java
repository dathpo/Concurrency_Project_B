import java.util.ArrayList;
import java.util.List;

public class Enumeration {
	Thread root;
	ThreadGroup[] groups;
	public Enumeration(Thread root){
		this.root = root; 
	}
	
	public List<Thread> createArrayOfGroups(){
		Thread[] temp = new Thread[root.activeCount()];
		root.getThreadGroup().enumerate(temp);
		List<Thread> allThreads= new ArrayList<Thread>();
		for(int i = 0; i<temp.length ; i++){
			if(temp[i]!=null){
				allThreads.add(i, temp[i]);
				System.out.println(allThreads.get(i).getName());
			}
		}
		return allThreads;			
	}	
}
