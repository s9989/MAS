package kwalifikowana;

public class Example {
	
	 public static void main(String[] args) {
		 
		 Role mod = new Role("Moderator");
		 Role admin = new Role("Administrator");
		 
		 User jan = new User("Jan", "Kowalski", "jan@kowalski.com");
		 User antoni = new User("Antoni", "Nowak", "antoni@nowak.com");
		 
		 mod.addUser(jan);
		 mod.addUser(antoni);
		 
		 admin.addUser(jan);
		 
		 System.out.println( antoni + (mod.isAuthorized(antoni) ? " posiada rolę: " : " nie posiada roli: ") + mod);
		 System.out.println( antoni + (admin.isAuthorized(antoni) ? " posiada rolę: " : " nie posiada roli: ") + admin);
		 
	 }
	
}
