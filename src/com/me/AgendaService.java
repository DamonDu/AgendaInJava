package com.me;

import com.me.cmd.Cmd;
import com.me.data.User;
import com.me.util.Processor;

import java.util.Scanner;

import static java.util.Objects.hash;

public class AgendaService {

    public static void main(String[] args) {
	// write your code here
        operationLoop();
    }

    static void operationLoop() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            if(Processor.process(new Cmd(str)) == 1) {
                break;
            }
        }
    }
}
