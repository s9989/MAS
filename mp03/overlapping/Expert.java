package overlapping;

public class Expert extends User {

	public Expert(String name) {
		super(name);
	}
	
	public boolean isAdmin() {
		return false;
	}
	
	public boolean isExpert() {
		return true;
	}

}
