package com.me.util;

import com.me.data.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    static UserManager _userManager;
    Map<Integer, User> allUsers;
    UserAgendaManager userAgendaManager;
    User currentUser;

    private UserManager() {
        _userManager.allUsers = new HashMap();
        userAgendaManager = null;
        currentUser = null;
    }

    public static UserManager _getInstance() {
        if (_userManager == null) {
            _userManager = new UserManager();
        }
        return _userManager;
    }

    public boolean login(User user) {
        try {
            if (ifUserExist(user)) {
                //throw
                return false;
            }
            this.allUsers.put(user.getUid(), user);
            return true;
        }
        finally {

        }
    }

    public boolean login(String name, String password) {
        try {
            return login(new User(name, password));
        }
        finally {

        }
    }

    public boolean signUp(String name, String password) {
        try {
            if (checkPassword(name, password)) {
                this.currentUser = allUsers.get(name.hashCode());
                userAgendaManager = UserAgendaManager._getInstance(currentUser);
                return true;
            }
            else {
                return false;
            }
        }
        finally {

        }
    }

    public boolean ifUserExist(User user) {
        return this.allUsers.containsKey(user.getUid());
    }

    public boolean ifUserExist(int uid) {
        return this.allUsers.containsKey(uid);
    }

    public boolean checkPassword(String name, String password) {
        try {
            if (ifUserExist(name.hashCode()) == false) {
                //throw
                return false;
            }
            return (allUsers.get(name.hashCode()).getPassword() == password);
        }
        finally {
            return false;
        }
    }
}