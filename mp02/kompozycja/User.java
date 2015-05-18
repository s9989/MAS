package kompozycja;

public class User {
	
	public String name;
	public String surname;
	
	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String toString() {
		return this.name + ' ' + this.surname;
	}

}
