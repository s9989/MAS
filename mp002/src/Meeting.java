import java.util.Date;
import java.util.HashMap;

class Meeting
{
	
	String title;
	Date date;
	HashMap<User, Member> members = new HashMap<User, Member>();
	
	Meeting(String title, Date date)
	{
		this.title = title;
		this.date = date;
	}
	
	void addMember(User user)
	{
		if (!this.members.containsKey(user)) {
			this.members.put(user, new Member(user));
		}
	}

	void removeMember(User user)
	{
		if (this.members.containsKey(user)) {
			this.members.remove(user);
		}
	}
	
	int getMembersCount()
	{
		return this.members.size();
	}

	private class Member {

		User user;

		Member(User user) {
			this.user = user;
		}

	}
}
