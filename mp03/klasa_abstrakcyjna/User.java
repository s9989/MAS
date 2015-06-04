package klasa_abstrakcyjna;

public abstract class User {

	String email;
	
	public User(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
}
