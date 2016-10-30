
public class main {
	public static void main(String args[]){		
		CreateGroupsAndThreads c1 = new CreateGroupsAndThreads();
		GetRoot g = new GetRoot();
		System.out.println(g.getRootThread());
		Enumeration e = new Enumeration(g.getRootThread());
		System.out.println(e.createArrayOfGroups());
	}
}
