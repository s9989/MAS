import java.util.Date;

class Task
{
	private User user;
	private Stage stage;
	private Date startAt;
	private Date endAt;
	
	Task(User user, Stage stage, Date startAt, Date endAt)
	{
		this.setStage(stage);
		this.setUser(user);

		this.startAt = startAt;
		this.endAt = endAt;
	}
	
	boolean isComplete()
	{
		Date now = new Date();
		return now.after(this.endAt);
	}
	
	public String toString()
	{
		return "'" + this.stage.toString() + "' wykonywane przez " + this.user.toString();
	}

	void setStage(Stage stage)
	{
		if (null == this.stage) {
			this.stage = stage;
			stage.addTask(this);
		}
	}

	void removeStage()
	{
		if (null != this.stage) {
			this.stage.removeTask(this);
			this.stage = null;
		}
	}

	void setUser(User user)
	{
		if (null == this.user) {
			this.user = user;
			user.addTask(this);
		}
	}

	void removeUser()
	{
		if (null != this.user) {
			this.user.removeTask(this);
			this.user = null;
		}
	}

}
