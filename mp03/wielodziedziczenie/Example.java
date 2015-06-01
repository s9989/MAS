/**
 * Klasa może dziedziczyć 
 * z więcej niż jednej klasy
 */
package wielodziedziczenie;

public class Example {

	public static void main(String[] args) {
		
		Customer customer = new Customer("Jan", "Kowalski");
		
		customer.setBudget(1000);
		System.out.println(customer + " posiada budżet w wysokości: " 
											+ customer.getBudget());
		//////////////////		
		Provider provider = new Provider("Alicja", "Janosz");
		
		try {
			provider.addProject("Koncepcja");
			provider.addProject("Wizualizacja");
			provider.addProject("Koncepcja");
		} catch (Exception e) {
			System.out.println("Pojawił się problem: " + e.getMessage());
		}
		
		System.out.println("Liczba projektów prowadzonych przez wykonawcę " 
						+ provider + " wynosi: " + provider.getProjectsCount());
		//////////////////
		Indepedent independent = new Indepedent("Maria", "Nowak");
		
		independent.setBudget(1000);
		System.out.println(independent + " posiada budżet w wysokości: " 
													+ independent.getBudget());
		try {
			independent.addProject("Wykonanie");
			independent.addProject("Nadzór");
		} catch (Exception e) {
			System.out.println("Pojawił się problem: " + e.getMessage());
		}
		
		System.out.println("Liczba projektów prowadzonych przez wykonawcę " 
					+ independent + " wynosi: " + provider.getProjectsCount());

	}

}
