package model;

import java.util.Date;
import java.util.List;

public class Expert extends User
{
    private String profession;
    private String company;

    public void addImplementation(Project project, String stageName, Date dateFrom, Date dateTo) throws Exception
    {
        project.addImplementation(stageName, this, dateFrom, dateTo);
    }

    public void removeImplementation(Project project, String stageName) throws Exception
    {
        project.removeImplementation(stageName, this);
    }
}
