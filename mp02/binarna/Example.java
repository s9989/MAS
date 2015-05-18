package binarna;

public class Example {
	
	 public static void main(String[] args) {
		 
		 Client urzad = new Client("Urząd Wojewódzki");
		 
		 Project zagospodarowanie = new Project("Zagospodarowanie terenu", urzad);
		 Project wizualizacja = new Project("Wizualizacja nowego oddziału", urzad);
		 
		 System.out.println(zagospodarowanie.getClientName());
		 System.out.println(wizualizacja.getClientName());
		 
	 }
	
}
