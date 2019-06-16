package model;

import lib.ObjectPlusPlus;

import java.util.Date;

public class Ownership extends ObjectPlusPlus
{
    /* Asocjacja zwykła */
    private Architect owner;
    private Project project;

    private Date dateFrom;
    private Date dateTo;

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Ownership(Date dateFrom, Date dateTo)
    {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
