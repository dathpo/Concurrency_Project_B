public class main {
	public static void main(String args[]){		
		CreateGroupsAndThreads cgat = new CreateGroupsAndThreads();
		cgat.build();
		Display d = new Display();
		new GetThreads(d);
		(new Thread(new RefreshThreads(d))).start();
		
}
}
