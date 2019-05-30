public abstract class User {

	protected String name;
	private String surname;
	String email;

	public User(String name) {
		this.name = name;
	}

	public User(String name, String surname) {
		this(name);
		this.surname = surname;
	}

	public User(String name, String surname, String email) {
		this(name, surname);
		this.email = email;
	}

	public String getEmail() {
		return this.email;
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

	public String toString() {
		return this.name + " " + this.surname;
	}
	
}
