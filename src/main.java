
public class main {
	public static void main(String args[]){
		
		ThreadGroup newGroup = new ThreadGroup("Thread Group A");
		Thread newT = new Thread(newGroup, "A thread in group A");
		
		System.out.print("Thread details :");
		System.out.println(newT.toString());
		System.out.print("Thread Name : ");
		System.out.println(newT.getName());
		System.out.print("Thread Priorty : ");
		System.out.println(newT.getPriority());		
		System.out.print("Thread is in group :");
		System.out.println(newT.getThreadGroup().getName());
		System.out.print("Thread ID :");
		System.out.println(newT.getId());
		System.out.print("Thread state :");
		System.out.println(newT.getState());
		newT.setDaemon(true);
		System.out.println(newT.getPriority());		
		System.out.print("daemon or nah :");
		System.out.println(newT.isDaemon());
	}
}
