package com.me.util;

import com.me.data.Agenda;
import com.me.data.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <h1>AgendaManager</h1>
 * <p>为接口类，要求其实现类实现处理议程的相关函数，并包括一个用于存储所有议程的队列地址静态量。
 *
 */
public interface AgendaManager {

    static List<Agenda> _allAgenda = new ArrayList<>();

    Agenda add(User other, Date startTime, Date endTime, String label);
    List<Agenda> queryByTime(Date startTime, Date endTime);
    boolean deleteById(int aid);
    boolean clear();

}
