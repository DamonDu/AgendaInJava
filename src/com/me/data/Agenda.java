package com.me.data;

import java.util.Date;

public class Agenda {

    static int num = 0;

    int aid;
    Date startDate;
    Date endDate;
    User creator;
    User participator;
    String label;

    public Agenda(Date startDate, Date endDate, User participator, String label) {
        this.aid = num;
        this.startDate = startDate;
        this.endDate = endDate;
        //this.creator = null;
        this.participator = participator;
        this.label = label;
    }

    public Agenda() {
        this(null, null, null, null);
    }

    public int getAid() {
        return aid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public User getCreator() {
        return creator;
    }

    public User getParticipator() {
        return participator;
    }

    public String getLabel() {
        return label;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setParticipator(User participator) {
        this.participator = participator;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
