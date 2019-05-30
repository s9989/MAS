public class Expert extends User {

	public Expert(String name)
	{
		super(name);
	}

	public Expert(String name, String surname)
	{
		super(name, surname);
	}

	public Expert(String name, String surname, String email)
	{
		super(name, surname, email);
	}

	public boolean isAdmin() {
		return false;
	}

	public boolean isExpert() {
		return true;
	}
}
