package z_atrybutem;

public class Stage {

	public int number;
	public String name;
	
	public Stage(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public String toString() {
		return this.number + ". " + this.name;
	}

}
