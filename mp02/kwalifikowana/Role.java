package kwalifikowana;

import java.util.Hashtable;

public class Role {

	public String name;
	
	public Role(String name) {
		this.name = name;
	}
	
	Hashtable<String, User> users = new Hashtable<String, User>();
	
	public void addUser(User user) {
		this.users.put(user.email, user);
	}

	public void removeUser(String email) {
		this.users.remove(email);
	}
	
	public boolean isAuthorized(User user) {
		return this.users.containsKey(user.email);
	}
	
	public String toString() {
		return this.name;
	}
	
}
