/**
 * A program that tests your implementation that
 * list all thread groups
 * and threads within each group -
 * in the JVM
 * @author e1007400
 *
 */
public class CreateDummyGroups {
	
	
		
	
	
	public CreateDummyGroups()
	{
		// create a few thread groups
		ThreadGroup a = new ThreadGroup("G-A");
		ThreadGroup b = new ThreadGroup("G-B");
		ThreadGroup c = new ThreadGroup(a,"G-C");
		
		// create a few threads belonging to the above thread groups
		
		(new Thread(a, new GroupWorker())).start();
		(new Thread(a, new GroupWorker())).start();
		(new Thread(a, new GroupWorker())).start();
		(new Thread(b, new GroupWorker())).start();
		(new Thread(c, new GroupWorker())).start();
		(new Thread(c, new GroupWorker())).start();
		
	/*	a = Thread.currentThread().getThreadGroup();
		int agc = a.activeGroupCount();
		//System.out.println ("Active thread groups in " + a.getName () +
       //         " thread group: " + agc);
		
		
		a.list ();
*/
		ThreadGroup rootThreadGroup = Thread.currentThread( ).getThreadGroup( );
		ThreadGroup parentGroup;
		while ( ( parentGroup = rootThreadGroup.getParent() ) != null ) {
			rootThreadGroup = parentGroup;
		   
		}
		Thread[] threads = new Thread[ rootThreadGroup.activeCount() ];
        rootThreadGroup.enumerate( threads, true );
        int i=0;   
         String groupName ="";
        while ( i< threads.length) {
               if(!groupName.equals(threads[i].getThreadGroup().getName())){
                     groupName = threads[i].getThreadGroup().getName();
                     System.out.println(threads[i].getThreadGroup().getName());
               }
 //System.out.println("Name : " + threads[i].getName() + ",  ID : "+ threads[i].getId()  +",  State : " + threads[i].getState() + ",  IS Demon :"+ threads[i].isDaemon() );
 System.out.println("\tName : " + threads[i].getName() + ",  ID : "+ threads[i].getId()  +",  State : " + threads[i].getState() + ",  IS Demon :"+ threads[i].isDaemon() );
  i++;
        }

		
	}
	public static void main(String[] args) {
		
		CreateDummyGroups cdg = new CreateDummyGroups();
		
		
	}
	
	

}
