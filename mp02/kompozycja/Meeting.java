package kompozycja;

import java.util.ArrayList;
import java.util.Date;

public class Meeting {
	
	public String title;
	public Date date;
	ArrayList<User> members = new ArrayList<User>(); 
	
	public Meeting(String title, Date date) {
		this.title = title;
	}
	
	public void addMember(User user) {
		this.members.add(user);
	}
	
	public int getMembersCount() {
		return this.members.size();
	}
	
}
