
public class main {
	public static void main(String args[]){
		
		ThreadGroup a = new ThreadGroup("G-A");
		ThreadGroup b = new ThreadGroup("G-B");
		ThreadGroup c = new ThreadGroup(a,"G-C");
		
		(new Thread(a, new GroupWorker())).start();
		(new Thread(a, new GroupWorker())).start();
		(new Thread(a, new GroupWorker())).start();
		(new Thread(b, new GroupWorker())).start();
		(new Thread(c, new GroupWorker())).start();
		(new Thread(c, new GroupWorker())).start();
		
		GetRoot g = new GetRoot();
		System.out.println(g.getRootThread());
		Enumeration e = new Enumeration(g.getRootThread());
		e.createArrayOfGroups();

	}
}
