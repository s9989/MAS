import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Stage {

	private int number;
	private String name;
	private List<Task> tasks;
	
	Stage(int number, String name)
	{
		this.number = number;
		this.name = name;
		this.tasks = new ArrayList<>();
	}
	
	public String toString()
	{
		return this.number + ". " + this.name;
	}

	void assignUser(User user, Date startAt, Date endAt)
	{
		new Task(user, this, startAt, endAt);
	}

	void addTask(Task task)
	{
		if (!this.tasks.contains(task)) {
			this.tasks.add(task);
			task.setStage(this);
		}
	}

	void removeTask(Task task)
	{
		if (this.tasks.contains(task)) {
			this.tasks.add(task);
			task.removeStage();
		}
	}

	void printReport()
	{
		for (Task task : this.tasks) {
			System.out.println(task + " - " + ( task.isComplete() ? "wykonane" : "niewykonane"));
		}
	}

}
