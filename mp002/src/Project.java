

class Project {
	
	private String name;
	private Client client;
	
	Project(String name)
	{
		this.name = name;
	}

	void addClient(Client client)
	{
		if (null == this.client) {
			this.client = client;
			client.addProject(this);
		}
	}

	void removeClient()
	{
		this.client = null;
	}
	
	String getClientName()
	{
		return this.client.getName();
	}
	
	public String toString()
	{
		return this.name;
	}

}
