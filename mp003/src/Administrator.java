public class Administrator extends User {

	public Administrator(String name)
	{
		super(name);
	}

	public Administrator(String name, String surname)
	{
		super(name, surname);
	}

	public Administrator(String name, String surname, String email)
	{
		super(name, surname, email);
	}

	public boolean isAdmin() {
		return true;
	}

	public boolean isExpert() {
		return false;
	}
}
