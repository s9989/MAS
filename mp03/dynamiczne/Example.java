/**
 * Obiekt nie musi być wystąpieniem 
 * jednej klasy przez cały okres swojego życia
 */
package dynamiczne;

public class Example {

	public static void main(String[] args) {

		Project project;
		Concept concept = new Concept("Koncepcja zabudowy");
		Procurement procurement = new Procurement("Zamówienie publiczne placu miejskiego");
		
		project = concept;
		
		System.out.println(project.getName() + " - " + project.getType());
		
		project = procurement;

		System.out.println(project.getName() + " - " + project.getType());
		
	}

}
