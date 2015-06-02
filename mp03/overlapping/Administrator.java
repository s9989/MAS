package overlapping;

public class Administrator extends User {

	public Administrator(String name) {
		super(name);
	}
	
	public boolean isAdmin() {
		return true;
	}
	
	public boolean isExpert() {
		return false;
	}

}
