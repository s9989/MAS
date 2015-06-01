package wielodziedziczenie;

abstract class User {
	
	private String name;
	private String surname;

	public String getName() {
		return this.name;
	};

	public String getSurname() {
		return this.surname;
	};
	
	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String toString() {
		return this.name + " " + this.surname;
	}

}
