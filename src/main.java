
public class main {
	public static void main(String args[]){
		
		ThreadGroup newGroup = new ThreadGroup("Thread Group A");
		Thread newT = new Thread(newGroup, "A thread in group A");
		
		System.out.println(newT.toString());
		System.out.println(newT.getId());
		System.out.println(newT.getState());
		newT.setDaemon(true);
		System.out.println(newT.isDaemon());
		System.out.println(newT.getState());
		System.out.println(newT.getThreadGroup().getName());
		
	}
}
