/**
 * Podział podklas pod względem
 * różnych aspektów
 * 
 * Typ dokumentu:
 * - archiwalny
 * - przetwarzany
 * - szkic
 * 
 * Rodzaj dokumentu:
 * - opracowanie
 * - skan
 * - wytyczne
 */
package wieloaspektowe;

public class Example {

	public static void main(String[] args) {
		
		ProcessedGuideLines doc1 = new ProcessedGuideLines("Wytyczne - Żagiel");
		ArchiveElaboration doc2 = new ArchiveElaboration("Opracowanie techniczne - Żagiel");
		
		try {
			
			doc1.addGuideline("Sporządzić protokół");
			doc1.addGuideline("Zweryfikować dane");
			doc1.printGuidelines();
			
			doc2.setComment("Wykonane prawidłowo");
			doc2.printComment();
			
		} catch (Exception e) {
			System.out.println("Błąd: " + e.getMessage());
		}

	}

}
