public class main {
	public static void main(String args[]){		
		new CreateGroupsAndThreads();
		Display d = new Display();
		new GetThreads(d);
		(new Thread(new RefreshThreads(d))).start();
		
}
}
