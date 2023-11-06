package com.ll;

import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    public void run() {
        String cmd;

        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");

        cmd = scanner.nextLine();

        if (cmd.equals("종료")) {
            System.exit(0);
        }

        if (cmd.equals("등록")) {
            createQuotes();
        }
    }

    private void createQuotes() {
        System.out.print("명언 : ");
        String quotes = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
    }
}
