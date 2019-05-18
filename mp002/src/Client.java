import java.util.ArrayList;
import java.util.List;

class Client
{
	private String name;
	private List<Project> projects;

	Client(String name)
	{
		this.name = name;
		this.projects = new ArrayList<>();
	}

	void addProject(Project project)
	{
		if (!this.projects.contains(project)) {
			this.projects.add(project);
			project.addClient(this);
		}
	}

	void removeProject(Project project)
	{
		if (this.projects.contains(project)) {
			this.projects.remove(project);
			project.removeClient();
		}
	}

	String getName()
	{
		return this.name;
	}


	
}
