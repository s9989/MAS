package model;

import lib.ObjectPlusPlus;

import java.util.Date;

public class Ownership extends ObjectPlusPlus
{
    private Architect owner;
    private Project project;

    private Date dateFrom;
    private Date dateTo;

    public Ownership(Date dateFrom, Date dateTo)
    {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
