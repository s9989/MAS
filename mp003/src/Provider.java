public class Provider extends User implements IProvider {

	int projectCount = 0;
	String[] projects = new String[10];
	
	@Override
	public void addProject(String projectName) throws Exception {
		
		if (this.projectCount > 9) {
			throw new Exception("Can't add more than 10 projects");
		}
		
		this.projects[this.projectCount] = projectName;
		this.projectCount ++;
		
	}

	@Override
	public int getProjectsCount() {
		return this.projectCount;
	}
	
	public Provider(String name, String surname) {
		super(name, surname);
	}

}
