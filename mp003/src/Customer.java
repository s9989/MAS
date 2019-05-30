public class Customer extends User implements ICustomer {

	private int budget;
	
	@Override
	public int getBudget() {
		return this.budget;
	}

	@Override
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public Customer(String name, String surname) {
		super(name, surname);
	}

}
