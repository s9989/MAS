public class Indepedent extends User implements ICustomer, IProvider {

	private int budget;
	int projectCount = 0;
	String[] projects = new String[10];
	
	@Override
	public void addProject(String projectName) throws Exception {
		
		if (this.projectCount > 9) {
			throw new Exception("Can't add more projects");
		}
		
		this.projects[this.projectCount] = projectName;
		this.projectCount ++;
		
	}

	@Override
	public int getProjectsCount() {
		return this.projectCount;
	}
	
	@Override
	public int getBudget() {
		return this.budget;
	}

	@Override
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public Indepedent(String name, String surname) {
		super(name, surname);
	}

}
