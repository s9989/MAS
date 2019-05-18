import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private String surname;
	private String email;
	private List<Task> tasks;
	private List<Role> roles;
	
	User(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
		this.tasks = new ArrayList<>();
		this.roles = new ArrayList<>();
	}

	User(String name, String surname, String email)
	{
		this(name, surname);
		this.email = email;
	}
	
	public String toString()
	{
		String result = this.name + ' ' + this.surname;

		if (null != this.email) {
			result = result + ' ' + this.email;
		}

		return result;
	}

	void addTask(Task task)
	{
		if (!this.tasks.contains(task)) {
			this.tasks.add(task);
			task.setUser(this);
		}
	}

	void removeTask(Task task)
	{
		if (this.tasks.contains(task)) {
			this.tasks.add(task);
			task.removeUser();
		}
	}

	void addRole(Role role)
	{
		if (!this.roles.contains(role)) {
			this.roles.add(role);
			role.addUser(this);
		}
	}

	void removeRole(Role role)
	{
		if (this.roles.contains(role)) {
			role.removeUser(this);
			this.roles.remove(role);
		}
	}

	String getEmail()
	{
		return this.email;
	}
}
