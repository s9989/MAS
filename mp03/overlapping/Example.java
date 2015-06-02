/**
 * Przecięcie zbiorów obiektów 
 * podklas nie musi być zbiorem pustym
 */
package overlapping;

public class Example {

	static private void changeUsername(User user, String name, User changer) {
		if (changer.isAdmin()) {
			user.setName(name);
			System.out.println("Zmieniono nazwę użytkownika na \"" + name + "\"");
		} else {
			System.out.println("Brak uprawnień");
		}
	}
	
	public static void main(String[] args) {
		
		Administrator admin = new Administrator("Jan");
		Expert expert = new Expert("Zbigniew");
		ExpertAdministrator expert_admin = new ExpertAdministrator("Dominik");
		
		Example.changeUsername(admin, "Alex", expert);
		Example.changeUsername(admin, "Alex", expert_admin);

	}

}
