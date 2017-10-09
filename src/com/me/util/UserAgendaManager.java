package com.me.util;

import com.me.data.Agenda;
import com.me.data.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAgendaManager implements AgendaManager {

    static UserAgendaManager _userAgendaManager;

    List<Agenda> createAgenda;
    List<Agenda> participateAgenda;
    User currentUser;

    private UserAgendaManager(User currentUser) {
        this.currentUser = currentUser;
        for (Agenda a : _allAgenda
             ) {
        if (a.getCreator() == currentUser)
            createAgenda.add(a);
        if (a.getParticipator() == currentUser)
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
    public void add(User other, Date startTime, Date endTime, String label) {
        try {
            Agenda addAgenda = new Agenda(currentUser, other, startTime, endTime, label);
            createAgenda.add(addAgenda);
            _allAgenda.add(addAgenda);
        }
        finally {
            return;
        }
    }

    @Override
    public List<Agenda> queryByTime(Date startTime, Date endTime) {
        try {
            List<Agenda> queryAgendas = new ArrayList<>();
            for (Agenda a : _allAgenda
                 ) {
                if (a.getStartTime().before(endTime) && a.getEndTime().after(startTime)) {
                    queryAgendas.add(a);
                }
            }
            return queryAgendas;
        }
        finally {

        }
    }

    @Override
    public void deleteById(int aid) {
        try {
            for (Agenda a : createAgenda
                 ) {
                if (a.getAid() == aid) {
                    createAgenda.remove(a);
                    _allAgenda.remove(a);
                    return;
                }
            }
            //throw
        }
        finally {
            return;
        }
    }

    @Override
    public void clear() {
        try {
            _allAgenda.removeAll(createAgenda);
            createAgenda.clear();
        }
        finally {
            return;
        }
    }
}
