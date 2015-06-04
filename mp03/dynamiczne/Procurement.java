package dynamiczne;

public class Procurement implements Project {
	
	String name;
	
	public Procurement(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getType() {
		return "zamówienie publiczne";
	}
}
