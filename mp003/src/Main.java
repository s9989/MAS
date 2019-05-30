public class Main {

    public static void main(String[] args)
    {
        dynamic_example();
        abstract_example();
        overlapping_example();
        multiaspect_example();
        multiple_inheritance_example();

    }

    /**
     * Dynamiczne
     *
     * Obiekt nie musi być wystąpieniem
     * jednej klasy przez cały okres swojego życia
     */
    private static void dynamic_example()
    {
        Project project;
        Concept concept = new Concept("Koncepcja zabudowy");
        Procurement procurement = new Procurement("Zamówienie publiczne placu miejskiego");

        project = concept;

        System.out.println(project.getName() + " - " + project.getType());

        project = procurement;

        System.out.println(project.getName() + " - " + project.getType());
    }

    private static void showUsersEmail(User user) {
        System.out.println(user.getEmail());
    }

    /**
     * Klasa abstrakcyjna
     *
     * Klasa abstrakcyjna zawiera metody
     * wspólne dla wszystkich klas dziedziczących
     */
    private static void abstract_example()
    {
        Administrator admin = new Administrator("Jan", "Kowalski", "admin@example.com");
        Expert expert = new Expert("Edward", "Nowak", "expert@example.com");

        showUsersEmail(admin);
        showUsersEmail(expert);
    }

    private static void changeUsername(User user, String name, User changer)
    {
        if (changer.isAdmin()) {
            user.setName(name);
            System.out.println("Zmieniono nazwę użytkownika na \"" + name + "\"");
        } else {
            System.out.println("Brak uprawnień");
        }
    }

    /**
     * Overlapping
     *
     * Przecięcie zbiorów obiektów
     * podklas nie musi być zbiorem pustym
     */
    private static void overlapping_example()
    {
        Administrator admin = new Administrator("Jan");
        Expert expert = new Expert("Zbigniew");
        ExpertAdministrator expert_admin = new ExpertAdministrator("Dominik");

        changeUsername(admin, "Alex", expert);
        changeUsername(admin, "Joe", expert_admin);
    }

    /**
     * Wieloaspektowe
     *
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
    private static void multiaspect_example()
    {
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

    /**
     * Wielodziedziczenie
     *
     * Klasa może dziedziczyć
     * z więcej niż jednej klasy
     */
    private static void multiple_inheritance_example()
    {
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
