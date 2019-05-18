import java.util.Hashtable;

class Role {

	private String name;

	Role(String name)
	{
		this.name = name;
	}

	private Hashtable<String, User> users = new Hashtable<>();

	void addUser(User user)
	{
		if (!this.users.containsKey(user.getEmail())) {
			this.users.put(user.getEmail(), user);
			user.addRole(this);
		}
	}

	void removeUser(User user)
	{
		if (this.users.containsKey(user.getEmail())) {
			user.removeRole(this);
			this.users.remove(user.getEmail());
		}
	}

	boolean isAuthorized(User user)
	{
		return this.users.containsKey(user.getEmail());
	}

	public String toString()
	{
		return this.name;
	}

}
