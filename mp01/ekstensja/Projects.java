package ekstensja;

import java.util.Vector;

/* Ekstensja */
public class Projects {
	
	private Vector<Project> collection = new Vector<Project>();
	
	public void add(Project project) {
		this.collection.add(project);
	}
	
	public void remove(Project project) {
		this.collection.remove(project);
	}
	
	public void showAll() {
		System.out.println("All projects:");
		for (Project p : this.collection) {
			System.out.println(p);
		}
	}
	
}
