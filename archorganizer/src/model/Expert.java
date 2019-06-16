package model;

import java.util.Date;

public class Expert extends User
{
    private String profession;
    private String company;

    public Expert(String name, String surname) {
        super(name, surname);
    }

    public Expert(String name, String surname, String profession) {
        super(name, surname);
        this.profession = profession;
    }

    /**
     * Dodanie powiązania specjalisty z etapem projektu
     *
     * @param project wskazany projekt
     * @param stageName nazwa etapu projektu
     * @param dateFrom data od
     * @param dateTo data do
     * @throws Exception w wypadku braku etapu w projekcie
     */
    public void addImplementation(Project project, String stageName, Date dateFrom, Date dateTo) throws Exception
    {
        project.addImplementation(stageName, this, dateFrom, dateTo);
    }

    /**
     * Usunięcie powiązania specjalisty z etapem projektu
     *
     * @param project wskazany projekt
     * @param stageName nazwa etapu projektu
     * @throws Exception w wypadku braku etapu w projekcie
     */
    public void removeImplementation(Project project, String stageName) throws Exception
    {
        project.removeImplementation(stageName, this);
    }
}
