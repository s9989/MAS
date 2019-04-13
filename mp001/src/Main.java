import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) throws Exception
    {
        System.out.println("Uruchomienie.");

        System.out.println("Zaczytanie danych.");
        try {
            Users.load();
        } catch (FileNotFoundException ex) {
            // do nothing - first run
        }

        System.out.println("Wyswietlenie danych.");
        Users.print();

        var newUser = new User("Jan", "Kowalski", LocalDate.of(1986, Month.JANUARY, 15));

        System.out.println("Dodanie nowych danych.");
        Users.add(newUser);

        System.out.println("Wyswietlenie danych.");
        Users.print();

        System.out.println("Zapisanie danych.");
        Users.save();
    }

}
