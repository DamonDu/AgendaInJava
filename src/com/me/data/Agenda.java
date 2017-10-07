package com.me.data;

import java.util.Date;

public class Agenda {

    static int _num = 0;

    int aid;
    Date startTime;
    Date endTime;
    User creator;
    User participator;
    String label;

    public Agenda(User creator, User participator, Date startTime, Date endTime, String label) {
        this.aid = _num;
        this.startTime = startTime;
        this.endTime = endTime;
        this.creator = creator;
        this.participator = participator;
        this.label = label;
        _num++;
    }

    public Agenda() {
        this(null, null, null, null, null);
    }

    public int getAid() {
        return aid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
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

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setParticipator(User participator) {
        this.participator = participator;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
