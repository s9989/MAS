package ekstensja_trwalosc;

public class Project {
	
	private int id;
	private String name;
	private long deadline;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getDeadline() {
		return this.deadline;
	}

}
