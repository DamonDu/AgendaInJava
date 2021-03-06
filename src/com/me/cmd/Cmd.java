package com.me.cmd;

import com.me.ui.UI;


/**
 * <h1>Cmd</h1>
 * <p>提供对用户CMD界面输入的命令的检查，解析方法。
 *
 */
public class Cmd {

    Command command;
    String[] args;
    int argsNum;

    public Cmd() {
        this.command = null;
        this.args = null;
    }

    public Cmd(String input) {
        try {
            if (!input.isEmpty()) {
                String arr[] = input.split("\\s+");
                parseCmd(arr[0]);
                if (this.command == Command.qt) {
                    return;
                }
                if (this.command == null) {
                    throw new Exception("Command syntax error!");
                }
                if ((arr.length - 1) != this.argsNum){
                    throw new Exception("Parameter error!");
                }
                args = new String[arr.length - 1];
                for (int i = 1; i < arr.length; i++) {
                    args[i - 1] = arr[i];
                }
            }
        }
        catch (Exception e){
            UI.printException(e);
        }
    }

    private void parseCmd(String cmd) {
        switch (cmd.toLowerCase()) {
            case "register":
                this.command = Command.reg;
                this.argsNum = 2;
                break;
            case "add":
                this.command = Command.add;
                this.argsNum = 6;
                break;
            case "query":
                this.command = Command.qry;
                this.argsNum = 4;
                break;
            case "delete":
                this.command = Command.del;
                this.argsNum = 3;
                break;
            case "clear":
                this.command = Command.clr;
                this.argsNum = 2;
                break;
            case "batch":
                this.command = Command.bat;
                this.argsNum = 1;
                break;
            case "quit":
                this.command = Command.qt;
                this.argsNum = 0;
                break;
            default:
                this.command = null;
                break;
        }
    }

    public Command getCommand() {
        return command;
    }

    public String[] getArgs() {
        return args;
    }
}
