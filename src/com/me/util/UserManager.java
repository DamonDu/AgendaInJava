package com.me.util;

import com.me.data.User;
import com.me.ui.UI;

import java.util.HashMap;
import java.util.Map;


/**
 * <h1>UserManager</h1>
 * <p>维护一个完整的用户集合，并且提供一系列处理用户的方法，如注册，查重等。
 *
 */
public class UserManager {

    static UserManager _userManager;
    Map<Integer, User> allUsers;
    UserAgendaManager userAgendaManager;
    User currentUser;

    private UserManager() {
        allUsers = new HashMap();
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
                throw new Exception("User Exist!");
            }
            this.allUsers.put(user.getUid(), user);
            return true;
        }
        catch (Exception e) {
            UI.printException(e);
            return false;
        }
    }

    public boolean login(String name, String password) {
            return login(new User(name, password));
    }

    public boolean signUp(String name, String password) {
        try {
            if (checkPassword(name, password)) {
                this.currentUser = allUsers.get(name.hashCode());
                userAgendaManager = UserAgendaManager._getInstance(currentUser);
                return true;
            }
            else {
                throw new Exception("Wrong Password!");
            }
        }
        catch (Exception e){
            UI.printException(e);
            return false;
        }
    }

    static public boolean ifUserExist(User user) {
        return _getInstance().allUsers.containsKey(user.getUid());
    }

    static public boolean ifUserExist(int uid) {
        return _getInstance().allUsers.containsKey(uid);
    }

    public boolean checkPassword(String name, String password) {
        try {
            if ((ifUserExist(name.hashCode())) == false) {
                throw new Exception("User not exist!");
            }
            return (allUsers.get(name.hashCode()).getPassword().equals(password));
        }
        catch (Exception e){
            UI.printException(e);
            return false;
        }
    }

    public UserAgendaManager getUserAgendaManager() {
        return userAgendaManager;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    static public User getUserByName(String name) {
        try {
            int uid = User.getUidByName(name);
            if (!ifUserExist(uid)) {
                throw new Exception("User not exist!");
            }
            return _getInstance().allUsers.get(uid);
        }
        catch (Exception e){
            UI.printException(e);
            return null;
        }
    }
}
