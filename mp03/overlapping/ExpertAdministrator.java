package overlapping;

public class ExpertAdministrator extends User {

	public ExpertAdministrator(String name) {
		super(name);
	}
	
	public boolean isAdmin() {
		return true;
	}
	
	public boolean isExpert() {
		return true;
	}

}
