package com.me.util;

import com.me.data.Agenda;
import com.me.data.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface AgendaManager {

    static List<Agenda> _allAgenda = new ArrayList<>();

    void add(User other, Date startTime, Date endTime, String label);
    List<Agenda> queryByTime(Date startTime, Date endTime);
    void deleteById(int aid);
    void clear();

}
