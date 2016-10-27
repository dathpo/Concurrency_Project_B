import java.util.ArrayList;
import java.util.List;

public class Enumeration {
	ThreadGroup root;
	ThreadGroup[] groups;
	public Enumeration(ThreadGroup root){
		this.root = root; 
	}
	
	public List<Thread> createArrayOfGroups(){
		Thread[] temp = new Thread[root.activeCount()];
		//Thread[] temp = new Thread[root.activeCount()];
		root.enumerate(temp);
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
