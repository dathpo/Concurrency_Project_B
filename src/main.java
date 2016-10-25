
public class main {
	public static void main(String args[]){
		
		ThreadGroup g1 = new ThreadGroup("A");
		Thread t1 = new Thread(g1,"t1");
		Thread t2 = new Thread(g1,"t2");
		Thread t3 = new Thread(g1,"t3");
		Thread t4 = new Thread(g1,"t4");
		
		Enumeration e = new Enumeration(t3);
		e.createArrayOfGroups();

	}
}
