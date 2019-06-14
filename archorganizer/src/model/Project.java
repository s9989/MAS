package model;

import lib.ObjectPlusPlus;

import javax.print.Doc;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    private Date startAt;
    private Date endEt;
    private int netCost;
    private int grosCost;

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

    public Date getEndEt() {
        return endEt;
    }

    public void setEndEt(Date endEt) {
        this.endEt = endEt;
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

    private Map<String, Stage> stages;

    private List<Ownership> ownerships;

    public void addOwner(Architect architect, Date dateFrom, Date dateTo) throws Exception
    {
        Ownership ownership = new Ownership(dateFrom, dateTo);

        addLink("ownership", "project", architect);
        ownership.addLink("owner", "ownership", architect);
    }

    public void addMainOwner(Architect architect) throws Exception
    {
        this.addOwner(architect, this.startAt, this.endEt);
    }

    public void removeOwner(Architect architect) throws Exception
    {
        ObjectPlusPlus ownership = getLinkedObject("ownership", architect);
        ownership.removeLink("owner", "ownership", architect);
        removeLink("ownerhip", "project", architect);
    }

    public void addStage(String name, int cost)
    {
        Stage stage = new Stage(name, cost);
        addLink("stage", "project", stage, (Object) name);
    }

    public void removeStage(String name) throws Exception
    {
        ObjectPlusPlus targetObject = getLinkedObject("stage", (Object) name);
        removeLink("stage", "project", targetObject, (Object) name);
    }

    public void addImplementation(String stageName, Expert expert, Date dateFrom, Date dateTo) throws Exception
    {
        Stage stage = (Stage) getLinkedObject("stage", (Object) stageName);
        stage.appendExpert(expert, dateFrom, dateTo);
    }

    public void removeImplementation(String stageName, Expert expert) throws Exception
    {
        Stage stage = (Stage) getLinkedObject("stage", (Object) stageName);
        stage.removeExpert(expert);
    }

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

        public void addDocument(String name, String filename)
        {
            Document document = new Document(name, filename);
            addLink("document", "stage", document, (Object) name);
        }

        public void removeDocument(String name) throws Exception
        {
            ObjectPlusPlus targetObject = getLinkedObject("document", (Object) name);
            removeLink("document", "stage", targetObject, (Object) name);
        }

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

        public void appendExpert(Expert expert, Date fromDate, Date toDate)
        {
            Implementation implementation = new Implementation(fromDate, toDate);

            addLink("implementation", "stage", expert);
            implementation.addLink("expert", "implementation", expert);
        }

        public void removeExpert(Expert expert) throws Exception
        {
            ObjectPlusPlus ownership = getLinkedObject("ownership", expert);
            ownership.removeLink("owner", "ownership", expert);
            removeLink("ownerhip", "project", expert);
        }

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
