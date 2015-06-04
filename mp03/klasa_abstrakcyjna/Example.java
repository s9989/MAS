/**
 * Klasa abstrakcyjna zawiera metody
 * wspólne dla wszystkich klas dziedziczących
 */
package klasa_abstrakcyjna;

public class Example {

	private static void showUsersEmail(User user) {
		System.out.println(user.getEmail());
	}
	
	public static void main(String[] args) {
		
		Administrator admin = new Administrator("admin@example.com");
		Expert expert = new Expert("expert@example.com");
		
		Example.showUsersEmail(admin);
		Example.showUsersEmail(expert);

	}

}
