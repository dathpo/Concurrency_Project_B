
public class main {
	public static void main(String args[]){
		
		ThreadGroup g = new ThreadGroup("A");
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		Thread t3 = new Thread();
		Thread t4 = new Thread();
		
		Enumeration e = new Enumeration(t3);
		e.createArrayOfGroups();

	}
}
