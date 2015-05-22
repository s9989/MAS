package binarna;

public class Project {
	
	public String name;
	public Client client;
	
	public Project(String name, Client client) {
		this.name = name;
		this.client = client;
	}
	
	public String getClientName() {
		return this.client.name;
	}
	
	public String toString() {
		return this.name;
	}

}
