package model;

import lib.ObjectPlusPlus;
import lib.exception.NoLinksException;

import java.util.*;

public class Project extends ObjectPlusPlus
{
    private enum stageType
    {
        analysis, concept, executive, contructional
    }

    private enum status {
        NEW, IN_PROGRESS, COMPLETED
    }

    private String name;

    /* atrybut złożony */
    private Date startAt;
    private Date endAt;
    private int netCost;
    private int grosCost;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public int getNetCost() {
        return netCost;
    }

    public void setNetCost(int netCost) {
        this.netCost = netCost;
    }

    public int getGrosCost() {
        return grosCost;
    }

    public void setGrosCost(int grosCost) {
        this.grosCost = grosCost;
    }

    /* atrybut wyliczalny (pochodny) */
    public int getManDays()
    {
        return (int) Math.floor((getEndAt().getTime() - getStartAt().getTime()) / (1000 * 24 * 60 * 60));
    }

    /* atrybut powatarzalny*/
    private Map<String, Stage> stages;

    private List<Ownership> ownerships;

    /**
     * Dodawanie właściciela projektu
     *
     * @param architect Architekt - właściciel
     * @param dateFrom data od
     * @param dateTo data do
     */
    public void addOwner(Architect architect, Date dateFrom, Date dateTo)
    {
        Ownership ownership = new Ownership(dateFrom, dateTo);

        addLink("ownership", "project", ownership, architect);
        ownership.addLink("owner", "ownership", architect);
    }

    /**
     * Dodanie właściciela projektu przez cały czas trwania projektu
     *
     * @param architect Architekt - właściciel
     */
    public void addMainOwner(Architect architect)
    {
        this.addOwner(architect, this.startAt, this.endAt);
    }

    /**
     * Usunięcie właściciela z projektu
     *
     * @param architect Architekt - właściciel
     * @throws Exception w wypadku braku właściciela
     */
    public void removeOwner(Architect architect) throws Exception
    {
        ObjectPlusPlus ownership = getLinkedObject("ownership", architect);
        ownership.removeLink("owner", "ownership", architect);
        removeLink("ownerhip", "project", architect);
    }

    /**
     * Dodanie etapu do projektu
     * @param name nazwa etapu
     * @param cost koszt etapu
     */
    public void addStage(String name, int cost)
    {
        Stage stage = new Stage(name, cost);
        addLink("stage", "project", stage, (Object) name);
    }

    /**
     * Usunięcie etapu z projektu
     *
     * @param name nazwa etapu do usunięcia
     * @throws Exception w wypadku braku etapu o zadanej nazwie
     */
    public void removeStage(String name) throws Exception
    {
        ObjectPlusPlus targetObject = getLinkedObject("stage", (Object) name);
        removeLink("stage", "project", targetObject, (Object) name);
    }

    /**
     * Zwraca koszt etapu o zadanej nazwie
     *
     * @param name nazwa etapu
     * @return int koszt
     * @throws Exception w wypadku braku etapu w zadanej nazwie
     */
    public int getStageCost(String name) throws Exception
    {
        Stage stage;

        try {
            stage = (Stage) getLinkedObject("stage", name);
        } catch (NoLinksException e) {
            throw new Exception("Stage " + name + " not found");
        }

        return stage.getCost();
    }

    /**
     * Zwraca wszystkie nazwy etapów
     *
     * @return ArrayList<String> kolekcja nazw etapów
     */
    public ArrayList<String> getStageNames()
    {
        ArrayList<String> names = new ArrayList<>();

        try {
            for (ObjectPlusPlus o : getLinks("stage")) {
                Stage stage = (Stage) o;
                names.add(stage.getName());
            }
        } catch (NoLinksException e) {
            return names;
        }

        return names;
    }

    /**
     * Dodaje specjalistę do danego etapu
     *
     * @param stageName nazwa etapu
     * @param expert specjalista
     * @param dateFrom data od
     * @param dateTo data do
     * @throws Exception w przypadku braku etapu o zadanej nazwie
     */
    public void addImplementation(String stageName, Expert expert, Date dateFrom, Date dateTo) throws Exception
    {
        Stage stage = (Stage) getLinkedObject("stage", (Object) stageName);
        stage.appendExpert(expert, dateFrom, dateTo);
    }

    /**
     * Usuwa specjalistę z danego etapu
     *
     * @param stageName nazwa etapu
     * @param expert specjalista
     * @throws Exception w przypadku braku etapu o zadanej nazwie
     */
    public void removeImplementation(String stageName, Expert expert) throws Exception
    {
        Stage stage = (Stage) getLinkedObject("stage", (Object) stageName);
        stage.removeExpert(expert);
    }

    /**
     * Klasa etapu projektu (kompozycja)
     */
    private class Stage extends ObjectPlusPlus
    {
        private String name;
        private int cost;

        private List<Implementation> implementations;

        private List<Expert> experts;

        public Stage(String name, int cost)
        {
            this.name = name;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        /**
         * Dodaje dokument do etapu
         *
         * @param name nazwa dokumentu
         * @param filename nazwa pliku
         */
        public void addDocument(String name, String filename)
        {
            Document document = new Document(name, filename);
            addLink("document", "stage", document, (Object) name);
        }

        /**
         * Usuwa dokument z etapu
         *
         * @param name nazwa dokumentu
         * @throws Exception w przypadku braku dokumentu o zadanej nazwie
         */
        public void removeDocument(String name) throws Exception
        {
            ObjectPlusPlus targetObject = getLinkedObject("document", (Object) name);
            removeLink("document", "stage", targetObject, (Object) name);
        }

        /**
         * Klasa pośrednicząca między specjalistą (Expert) i etapem (Stage)
         */
        private class Implementation extends ObjectPlusPlus
        {
            private Date dateFrom;
            private Date dateTo;

            public Implementation(Date dateFrom, Date dateTo)
            {
                this.dateFrom = dateFrom;
                this.dateTo = dateTo;
            }
        }

        /**
         * Dodanie specjalisty do implementacj
         *
         * @param expert specjalista
         * @param fromDate data od
         * @param toDate data do
         */
        public void appendExpert(Expert expert, Date fromDate, Date toDate)
        {
            Implementation implementation = new Implementation(fromDate, toDate);

            addLink("implementation", "stage", implementation, expert);
            implementation.addLink("expert", "implementation", expert);
        }

        /**
         * Usunięcie specjalisty z implementacji
         *
         * @param expert specjalista
         * @throws Exception w wypadku braku specjalisty w implementacji
         */
        public void removeExpert(Expert expert) throws Exception
        {
            ObjectPlusPlus ownership = getLinkedObject("ownership", expert);
            ownership.removeLink("owner", "ownership", expert);
            removeLink("ownerhip", "project", expert);
        }

        /**
         * Klasa dokumentu - klasa wewnętrzna etapu (kompozycja)
         */
        private class Document extends ObjectPlusPlus
        {
            private String name;
            private String filename;
            private int size;

            public Document(String name, String filename)
            {
                this.name = name;
                this.filename = filename;
            }

            public void download()
            {
                //@todo: not implemented yet
            }
        }
    }
}
