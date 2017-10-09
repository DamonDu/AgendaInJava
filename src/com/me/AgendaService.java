package com.me;

import com.me.cmd.Cmd;
import com.me.ui.UI;
import com.me.util.Processor;

import java.util.Scanner;

/**
 * <h1>AgendaService</h1>
 * <p>程序入口，main函数调用一个 operationLoop 函数，提示用户输入命令，读取命令并调用函数处理。
 *
 */
public class AgendaService {

    public static void main(String[] args) {
        UI.printHelp();
        operationLoop();
    }

    static void operationLoop() {
        while (true) {
            UI.printSymbol();
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            //System.out.println(str);
            if(Processor.process(new Cmd(str)) == 1) {
                break;
            }
        }
    }
}
