package kompozycja;

import java.util.Date;

public class Example {
	
	 public static void main(String[] args) {
		 
		 User u1 = new User("Jan", "Kowalski");
		 User u2 = new User("Alekandra", "Karo");
		 User u3 = new User("Zbigniew", "Zalewski");
		 
		 Meeting meeting = new Meeting("Ustalenia wstępne", new Date());
		 
		 meeting.addMember(u1);
		 meeting.addMember(u2);
		 meeting.addMember(u3);
		 
		 System.out.println("Liczba uczestników spotkania: " +  meeting.getMembersCount());
		 
	 }
	
}
