package model;

import lib.ObjectPlusPlus;

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

    private Map<String, Stage> stages;

    private List<Ownership> ownerships;

    public void addStage(String name, int cost)
    {
        Stage stage = new Stage(name, cost);
        stages.put(name, stage);
    }

    public void removeStage(String name)
    {
        stages.remove(name);
    }

    private class Stage extends ObjectPlusPlus
    {
        private String name;
        private int cost;

        private List<Implementation> implementations;

        public Stage(String name, int cost)
        {
            this.name = name;
            this.cost = cost;
        }

        public void addDocument(String name, String filename)
        {
            //@todo: not implemented yet
        }

        public void removeDocument(String name)
        {
            //@todo: not implemented yet
        }

        public void appendExpert(Expert expert)
        {
            //@todo: not implemented yet
        }

        public class Document extends ObjectPlusPlus
        {
            private String name;
            private String filename;
            private int size;

            public void download()
            {
                //@todo: not implemented yet
            }
        }
    }
}
