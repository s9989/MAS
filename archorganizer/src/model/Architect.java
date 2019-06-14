package model;

import lib.ObjectPlusPlus;

import java.util.Date;
import java.util.List;

public class Architect extends Expert
{
    private List<Ownership> ownerships;

    public void addProject(Project project, Date dateFrom, Date dateTo)
    {
        Ownership ownership = new Ownership(dateFrom, dateTo);
        addLink("ownership", "owner", project);
        ownership.addLink("project", "ownership", project);
    }

    public void removeProject(Project project) throws Exception
    {
        ObjectPlusPlus ownership = getLinkedObject("ownership", project);
        ownership.removeLink("project", "ownership", project);
        removeLink("ownerhip", "owner", project);
    }
}
