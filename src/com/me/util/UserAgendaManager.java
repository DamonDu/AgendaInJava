package com.me.util;

import com.me.data.Agenda;
import com.me.data.User;
import com.me.ui.UI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <h1>UserAgendaManager</h1>
 * <p>实现了 AgendaManager 接口，向用户提供处理其议程的一系列方法，如添加、查找等。
 *
 */
public class UserAgendaManager implements AgendaManager {

    static UserAgendaManager _userAgendaManager;

    List<Agenda> createAgenda;
    List<Agenda> participateAgenda;
    User currentUser;

    private UserAgendaManager(User currentUser) {
        this.currentUser = currentUser;
        this.createAgenda = new ArrayList<>();
        this.participateAgenda= new ArrayList<>();
        for (Agenda a : _allAgenda
             ) {
            if (a.getCreator().equals(currentUser))
                createAgenda.add(a);
            if (a.getParticipator().equals(currentUser))
                participateAgenda.add(a);
    }
}

    public static UserAgendaManager _getInstance(User currentUser) {
        if (_userAgendaManager == null) {
            _userAgendaManager = new UserAgendaManager(currentUser);
        }
        return _userAgendaManager;
    }

    @Override
    public Agenda add(User other, Date startTime, Date endTime, String label) {
        try {
            if (startTime.after(endTime)){
                throw new Exception("Wrong Time!");
            }
            Agenda addAgenda = new Agenda(currentUser, other, startTime, endTime, label);
            createAgenda.add(addAgenda);
            _allAgenda.add(addAgenda);
            return addAgenda;
        }
        catch (Exception e) {
            UI.printException(e);
            return null;
        }
    }

    @Override
    public List<Agenda> queryByTime(Date startTime, Date endTime) {
        try {
            if (startTime.after(endTime)){
                throw new Exception("Wrong Time!");
            }
            List<Agenda> queryAgendas = new ArrayList<>();
            for (Agenda a : _allAgenda
                    ) {
                if (a.getStartTime().before(endTime) && a.getEndTime().after(startTime)) {
                    queryAgendas.add(a);
                }
            }
            return queryAgendas;
        }
        catch (Exception e) {
            UI.printException(e);
            return null;
        }
    }

    @Override
    public boolean deleteById(int aid) {
        try {
            for (Agenda a : createAgenda
                 ) {
                if (a.getAid() == aid) {
                    createAgenda.remove(a);
                    _allAgenda.remove(a);
                    return true;
                }
            }
            throw new Exception("User not exist!");
        }
        catch (Exception e){
            UI.printException(e);
            return false;
        }
    }

    @Override
    public boolean clear() {
        _allAgenda.removeAll(createAgenda);
        createAgenda.clear();
        return true;
    }
}
