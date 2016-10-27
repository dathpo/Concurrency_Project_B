
public class OutputDisplay {
	public void output(Thread[] threads){
		int i =0;
		String groupName = "";
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
}
