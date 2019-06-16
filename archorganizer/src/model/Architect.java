package model;

import lib.ObjectPlusPlus;

import java.util.Date;
import java.util.List;

public class Architect extends Expert
{
    private List<Ownership> ownerships;

    public Architect(String name, String surname) {
        super(name, surname);
    }

    /**
     * Dodawanie projektu, którego architekt jest właścicielem
     *
     * @param project projekt
     * @param dateFrom data początkowa opieki nad projektem
     * @param dateTo data końcowa opieki nad projektem
     */
    public void addProject(Project project, Date dateFrom, Date dateTo)
    {
        Ownership ownership = new Ownership(dateFrom, dateTo);
        addLink("ownership", "owner", project);
        ownership.addLink("project", "ownership", project);
    }

    /**
     * Usunięcie architekta jako właściciela z danego projektu
     *
     * @param project projekt
     * @throws Exception w wypadku nie posiadania danego projektu przez Architekta
     */
    public void removeProject(Project project) throws Exception
    {
        ObjectPlusPlus ownership = getLinkedObject("ownership", project);
        ownership.removeLink("project", "ownership", project);
        removeLink("ownerhip", "owner", project);
    }
}
