import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception
    {
        simpleExample();
        attributeExample();
        qualifiedExample();
        compositionExample();
    }

    private static void simpleExample()
    {
        System.out.println("Asocjacja zwykła:");

        Client urzad = new Client("Urząd Wojewódzki");

        Project zagospodarowanie = new Project("Zagospodarowanie terenu");
        Project wizualizacja = new Project("Wizualizacja nowego oddziału");

        zagospodarowanie.addClient(urzad);
        wizualizacja.addClient(urzad);

        System.out.println("Projekt '" + zagospodarowanie + "' (klient: " + zagospodarowanie.getClientName() + ")");
        System.out.println("Projekt '" + wizualizacja + "' (klient: " +  wizualizacja.getClientName() + ")");

        System.out.println();
    }

    private static void attributeExample()
    {
        System.out.println("Asocjacja z atrybutem:");

        User user1 = new User("Jan", "Kowalski");
        User user2 = new User("Anna", "Nowakowska");
        Stage stage1 = new Stage(1, "Wizualizacja projektu");
        Stage stage2 = new Stage(2, "Opracowanie projektu");

        stage1.assignUser(user1,
                new Date((new Date()).getTime() - (1000 * 60 * 60 * 24)),
                new Date((new Date()).getTime() + (1000 * 60 * 60 * 24))
        );

        stage2.assignUser(user2,
                new Date((new Date()).getTime()-(1000*60*60*24)),
                new Date((new Date()).getTime()-(1000))
        );

        stage1.printReport();
        stage2.printReport();

        System.out.println();
    }

    private static void qualifiedExample()
    {
        System.out.println("Asocjacja kwalifikowana:");

        Role mod = new Role("Moderator");
        Role admin = new Role("Administrator");

        User jan = new User("Jan", "Kowalski", "jan@kowalski.com");
        User antoni = new User("Antoni", "Nowak", "antoni@nowak.com");

        mod.addUser(jan);
        mod.addUser(antoni);

        admin.addUser(jan);

        System.out.println( antoni + (mod.isAuthorized(antoni) ? " posiada rolę: " : " nie posiada roli: ") + mod);
        System.out.println( antoni + (admin.isAuthorized(antoni) ? " posiada rolę: " : " nie posiada roli: ") + admin);

        System.out.println();
    }

    private static void compositionExample()
    {
        System.out.println("Kompozycja:");

        User u1 = new User("Jan", "Kowalski");
        User u2 = new User("Alekandra", "Karo");
        User u3 = new User("Zbigniew", "Zalewski");

        Meeting meeting = new Meeting("Ustalenia wstępne", new Date());

        meeting.addMember(u1);
        meeting.addMember(u2);
        meeting.addMember(u3);

        System.out.println("Liczba uczestników spotkania: " +  meeting.getMembersCount());

        System.out.println();
    }

}
