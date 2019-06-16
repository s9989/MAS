/**
 * Projekt ArchOrganizer
 * @author Jakub Kuryłowicz s9989
 * @version 1.0
 */
package main;

import model.Architect;
import model.Expert;
import model.Project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Initialize
{
    private static final String filepath = "data/projects.txt";

    /**
     * Skrótowa metoda dodająca specjalistę do etapu projektu przyjmująca daty w postaci tekstu
     *
     * @param project wskazany projekt
     * @param stageName nazwa etapu
     * @param expert specjalista
     * @param from data od
     * @param to data do
     */
    private static void addExpert(Project project, String stageName, Expert expert, String from, String to)
    {
        try {
            Date dateFrom = (new SimpleDateFormat("dd-MM-yyyy")).parse(from);
            Date dateTo   = (new SimpleDateFormat("dd-MM-yyyy")).parse(to);
            project.addImplementation(stageName, expert, dateFrom, dateTo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  Pomocniczna metoda zwracająca datę z zadanego tekstu
     * @param dateString tekst
     * @return Date data w formacie obiektu Date
     */
    public static Date getDateFromString(String dateString)
    {
        Date date = null;

        try {
            date = (new SimpleDateFormat("dd-MM-yyyy")).parse(dateString);
        } catch (Exception e) {
            // do nothing
        }

        return date;
    }

    /**
     * Metoda pomocniczna tworząca projekt
     *
     * @param name nazwa projektu
     * @param from data od
     * @param to data do
     * @return Project nowoutworzony obiekt Project
     */
    private static Project createProject(String name, String from, String to)
    {
        Project project = new Project(name);
        project.setStartAt(getDateFromString(from));
        project.setEndAt(getDateFromString(to));
        return project;
    }

    /**
     * Metoda generująca przykładowy stan ekstensji
     *
     * @param args nieużywane
     */
    public static void main(String[] args)
    {
        System.out.print("Preparing default data set... ");

        try {
            load();
        } catch (Exception e) {
            // do nothing
        }

        int p = 0;

        try {
            Iterable i = Project.getExtent(Project.class);
            p = ((ArrayList) i).size();
        } catch (ClassNotFoundException e) {
            // do nothing
        }

        if (p > 0) {
            System.out.println("data already exists. Bye!");
            return; // don't override data
        }

        Architect architect = new Architect("Jan", "Kowalski");

        Expert constructor = new Expert("Oglaf", "Żelazko", "konstruktor");
        Expert electrisian = new Expert("Filip", "Filipiński", "elektryk");
        Expert fireman = new Expert("Grzegorz", "Lato", "Rzeczoznawca przeciwpożarowy");
        Expert greenman = new Expert("Piotr", "Jak", "Projektant zieleni");

        Project project1 = createProject("Budynek mieszkalny", "01-05-2019", "15-07-2019");
        project1.addMainOwner(architect);

        project1.addStage("Projekt budowlany", 5000);

        /* Asocjacja z atrybutem */
        addExpert(project1, "Projekt budowlany", constructor, "13-05-2019", "29-06-2019");
        addExpert(project1, "Projekt budowlany", fireman, "13-05-2019", "29-06-2019");
        addExpert(project1, "Projekt budowlany", electrisian, "13-05-2019", "29-06-2019");

        Project project2 = createProject("Biurowiec", "13-08-2019", "31-12-2019");
        project2.addMainOwner(architect);

        /* Asocjacja kwalifikowana + kompozycja */
        project2.addStage("Koncepcja", 40000);
        project2.addStage("Analiza", 10000);
        project2.addStage("Projekt wykonawczy", 500000);

        addExpert(project2, "Analiza", fireman, "13-08-2019", "30-08-2019");
        addExpert(project2, "Analiza", greenman, "13-08-2019", "30-08-2019");
        addExpert(project2, "Koncepcja", architect, "10-09-2019", "30-09-2019");
        addExpert(project2, "Projekt wykonawczy", constructor, "13-05-2019", "29-06-2019");
        addExpert(project2, "Projekt wykonawczy", fireman, "13-05-2019", "29-06-2019");
        addExpert(project2, "Projekt wykonawczy", electrisian, "13-05-2019", "29-06-2019");

        save();
        System.out.println("done.");
    }

    /* ekstensja trwałość */

    /**
     * Zapisywanie ekstensji do pliku
     */
    public static void save()
    {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            Project.writeExtents(objectOut);

        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    /**
     *  Wczytywanie ekstensji z pliku
     * @throws Exception
     */
    public static void load() throws Exception
    {
        FileInputStream fileIn = new FileInputStream(filepath);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Project.readExtents(objectIn);
    }
}