package com.ll;

import java.util.Scanner;

public class App {
    public static void run(){
        String cmd;

        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");

        Scanner scanner = new Scanner(System.in);
        cmd = scanner.nextLine();

        if(cmd == "종료"){
            System.exit(0);
        }

    }
}
