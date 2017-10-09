package com.me.ui;

import com.me.data.Agenda;

import java.util.List;


/**
 * <h1>UI</h1>
 * <p>为IO交互类，包括了针对提示输入，结果输出，提示异常的相关交互输出。
 *
 */
public class UI {

    static public void printSymbol() {
        System.out.print("$");
    }

    static public void printOutput(Agenda agenda) {
        if (agenda != null) {
            System.out.println("Successfully add following agenda:");
            System.out.println("Meeting ID:" + agenda.getAid());
            System.out.println("Creator:" + agenda.getCreator().getName());
            System.out.println("Participator:" + agenda.getParticipator().getName());
            System.out.println("Start Time:" + agenda.getStartTime());
            System.out.println("End Time:" + agenda.getEndTime());
            System.out.println("Label:" + agenda.getLabel());
            System.out.println("-----------------------------------------");
        }
    }

    static public void printOutput(List<Agenda> list) {
        if (list != null) {
            System.out.println("Get following agendas:");
            for (Agenda a : list
                    ) {
                printOutput(a);
            }
        }
    }

    static public void printOutput(boolean b) {
        if (b) {
            System.out.println("Success!");
        }
        else {
            printFail();
        }
        System.out.println("-----------------------------------------");
    }

    static public void printFail() {
        System.out.println("Fail!");
    }

    static public void printException(Exception e) {
        System.out.println("Exception thrown: " + e.getMessage());
    }

    static public void printHelp() {
        System.out.println(
                "HELP:\n" +
                "   REGISTER:  $register [name] [password]\n" +
                "   ADD:       $add [name] [password] [other] [start] [end] [title]\n" +
                "   QUERY:     $query [name] [password] [start] [end]\n" +
                "   DELETE:    $delete [name] [password] [meetingid]\n" +
                "   CLEAR:     $clear [name] [password]\n" +
                "   BATCH:     $batch [filename]\n" +
                "   QUIT:      $quit\n" +
                "Parameter:\n" +
                "   [start], [end] should in the format: yyyy-mm-dd-HH:MM (Example: 2017-10-08-00:00)"
        );
        System.out.println("--------------------------------------------------------------------------------");
    }
}
