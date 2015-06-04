package dynamiczne;

public class Concept implements Project {

	String name;
	
	public Concept(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getType() {
		return "koncepcja";
	}

}
