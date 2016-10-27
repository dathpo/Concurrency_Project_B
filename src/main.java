
public class main {
	public static void main(String args[]){		
		CreateDummyGroups c1 = new CreateDummyGroups();
		GetRoot g = new GetRoot();
		System.out.println(g.getRootThread());
		Enumeration e = new Enumeration(g.getRootThread());
		System.out.println(e.createArrayOfGroups());
	}
}
