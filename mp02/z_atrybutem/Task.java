package z_atrybutem;

import java.util.Date;

public class Task {
	
	public User user;
	public Stage stage;
	
	public Date startAt;
	public Date endAt;
	
	public Task(User user, Stage stage, Date startAt, Date endAt) {
		this.user = user;
		this.stage = stage;
		
		this.startAt = startAt;
		this.endAt = endAt;
	}
	
	public boolean isComplete() {
		Date now = new Date();
		return now.after(this.endAt);
	}
	
	public String toString() {
		return "'" + this.stage.toString() + "' wykonywane przez " + this.user.toString();
	}
	
	
}
