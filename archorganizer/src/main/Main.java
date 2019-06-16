/**
 * Projekt ArchOrganizer
 * @author Jakub Kuryłowicz s9989
 * @version 1.0
 */
package main;

import view.AbstractView;
import view.HomePage;
import view.ObjectInjectable;
import view.ProjectPage;

import java.awt.*;
import java.util.HashMap;

public class Main
{
    public static AbstractView currentPage;
    public static HashMap<String, AbstractView> pages = new HashMap<>();

    /**
     * Główna metoda kodu, wczytuje dane i wywołuje interfejs graficzny
     * @param args nieużywane
     */
    public static void main(String[] args)
    {
        try {
            Initialize.load();
        } catch (Exception e) {
            System.out.println("Fatal error while loading extend:");
            e.printStackTrace();
            return;
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    HomePage homepage = new HomePage();
                    Main.pages.put("homepage", homepage);

                    ProjectPage projectPage = new ProjectPage();
                    Main.pages.put("project", projectPage);

                    currentPage = homepage;
                    currentPage.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Metoda przełączająca widoki (skrót)
     *
     * @param pageName nazwa wybranej strony
     */
    public static void switchPage(String pageName)
    {
        switchPage(pageName, null);
    }

    /* dziedziczenie dynamiczne */
    /**
     * Metoda przełączająca widoki z możliwością podłączenia głównego obiektu
     *
     * @param pageName nazwa wybranej strony
     * @param object obiekt do dołączenia
     */
    public static void switchPage(String pageName, Object object)
    {
        if (!pages.containsKey(pageName)) {
            return;
        }
        currentPage.setVisible(false);
        currentPage = pages.get(pageName);

        if (currentPage instanceof ObjectInjectable) {
            ((ObjectInjectable) currentPage).setObject(object);
        }

        currentPage.redraw();
        currentPage.repaint();
        currentPage.revalidate();
        currentPage.setVisible(true);
    }

    /**
     * Metoda zapisująca stan ekstensji
     */
    public static void saveProject()
    {
        Initialize.save();
    }

    /* Klasa abstrakcyjna */
    /* Overlapping */
    /* Wieloaspektowe */
    /* Wielodziedziczenie */
}
