package com.me.util;

import com.me.cmd.Cmd;
import com.me.cmd.Command;
import com.me.data.User;
import com.me.ui.UI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * <h1>Processor</h1>
 * <p>为总控制类，提供了对用户输入指令的解析和逻辑处理，并传出处理结果。
 *
 */
public class Processor {

    static public int process(Cmd cmd) {
        try {
            if (cmd.getCommand() == null) {
                return 0;
            }
            if (cmd.getCommand() == Command.qt)
                return 1;
            UserManager userManager = UserManager._getInstance();
            String args[] = cmd.getArgs();
            if (cmd.getCommand() == Command.reg) {
                UI.printOutput(userManager.login(args[0], args[1]));
                return 0;
            }
            if (cmd.getCommand() != Command.bat && !userManager.signUp(args[0], args[1])){
                UI.printFail();
                return 0;
            }
            UserAgendaManager userAgendaManager = userManager.getUserAgendaManager();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
            User other;
            Date startTime, endTime;
            String label;
            int aid;
            switch (cmd.getCommand().getValue()) {
                case 2:
                    other = UserManager.getUserByName(args[2]);
                    startTime = format.parse(args[3]);
                    endTime = format.parse(args[4]);
                    label = args[5];
                    UI.printOutput(userAgendaManager.add(other, startTime, endTime, label));;
                    break;
                case 3:
                    startTime = format.parse(args[2]);
                    endTime = format.parse(args[3]);
                    UI.printOutput(userAgendaManager.queryByTime(startTime, endTime));
                    break;
                case 4:
                    aid = Integer.parseInt(args[2]);
                    UI.printOutput(userAgendaManager.deleteById(aid));;
                    break;
                case 5:
                    UI.printOutput(userAgendaManager.clear());
                    break;
                case 6:
                    batch(args[0]);
                    break;
            }
            return 0;
        }
        catch (ParseException e) {
            UI.printException(e);
            return 0;
        }
    }

    static public void batch(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String str;

            while ((str = br.readLine()) != null) {
                process(new Cmd(str));
            }
        }
        catch (Exception e) {
            UI.printException(e);
        }
    }
}
