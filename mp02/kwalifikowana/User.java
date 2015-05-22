package kwalifikowana;

public class User {
	
	public String name;
	public String surname;
	public String email;
	
	public User(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	public String toString() {
		return this.name + ' ' + this.surname + " " + this.email;
	}

}
