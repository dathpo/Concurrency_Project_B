
public class main {
	public static void main(String args[]){		
		DisplayThreads d = new DisplayThreads();
		CreateGroupsAndThreads cgat = new CreateGroupsAndThreads();
		cgat.build();
		d.displayOutput(d.enumerate(d.getRoot()));
		
	}
}
