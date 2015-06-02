package overlapping;

public class User {

	protected String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public boolean isAdmin() {
		return false;
	}
	
	public boolean isExpert() {
		return false;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
