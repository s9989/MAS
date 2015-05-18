package przeslanianie;

public class User {
	
	static int ROLE_USER = 1;
	static int ROLE_DEVELOPER = 2;
	static int ROLE_ARCHITECT = 3;
	
	protected int role;
	
	User() {
		this.role = User.ROLE_USER;
	}
	
	public int getRole() {
		return this.role;
	}

}
