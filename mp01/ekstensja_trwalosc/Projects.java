package ekstensja_trwalosc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

/* Ekstensja trwała */
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
	
	public void saveProject(DataOutputStream stream, Project p) throws IOException {
		stream.writeInt(p.getId());
		stream.writeUTF(p.getName());
		stream.writeLong(p.getDeadline());
	}
	
	public Project loadProject(DataInputStream stream) throws IOException {
		Project p = new Project();
		
		p.setId( stream.readInt() );
		p.setName( stream.readUTF() );
		p.setDeadline( stream.readLong() );
		
		return p;
	}
	
	/* Ekstensja trwała - implementacja ręczna */
	public void saveAll(DataOutputStream stream) throws IOException {
		stream.writeInt(this.collection.capacity());
		for (Project p : this.collection) {
			this.saveProject(stream, p);
		}
	}
	
	/* Ekstensja trwała - implementacja ręczna */
	public void loadAll(DataInputStream stream) throws IOException {
		this.collection.removeAllElements();
		int count = stream.readInt();
		for (int i = 0; i < count; i++) {
			Project p = this.loadProject(stream);
			this.collection.add(p);
		}
	}
	
}
