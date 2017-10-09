package com.me.util;

import com.me.cmd.Cmd;
import com.me.cmd.Command;
import com.me.data.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Processor {

    static public int process(Cmd cmd) {
        try {
            if (cmd.getCommand() == Command.qt)
                return 1;
            UserManager userManager = UserManager._getInstance();
            String args[] = cmd.getArgs();
            if (cmd.getCommand() == Command.reg) {
                userManager.login(args[0], args[1]);
                return 0;
            }
            if (!userManager.signUp(args[0], args[1]))
                return 0;
            UserAgendaManager userAgendaManager = userManager.getUserAgendaManager();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
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
                    userAgendaManager.add(other, startTime, endTime, label);
                    break;
                case 3:
                    startTime = format.parse(args[2]);
                    endTime = format.parse(args[3]);
                    userAgendaManager.queryByTime(startTime, endTime);
                    break;
                case 4:
                    aid = Integer.parseInt(args[2]);
                    userAgendaManager.deleteById(aid);
                    break;
                case 5:
                    userAgendaManager.clear();
                    break;
                case 6:
                    batch(args[2]);
                    break;
            }
            return 0;
        }
        catch (ParseException e){
            return 1;
        }
        finally {

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
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        }
    }
}
