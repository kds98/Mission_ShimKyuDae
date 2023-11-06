package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private int quotesNumber = 0;
    List<String> quotesList = new ArrayList<>();
    List<String> authorList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        String cmd;

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");

            cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                System.exit(0);
            }

            if (cmd.equals("등록")) {
                createQuotes();
            }

            if (cmd.equals("목록")) {
                listView();
            }
        }
    }

    private void listView() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = quotesList.size() - 1; i >= 0; i--) {
            System.out.printf("%d / %s / %s\n", i + 1, authorList.get(i), quotesList.get(i));
        }
    }

    private void createQuotes() {
        System.out.print("명언 : ");
//        String quotes = scanner.nextLine();
        quotesList.add(scanner.nextLine());
        System.out.print("작가 : ");
//        String author = scanner.nextLine();
        authorList.add(scanner.nextLine());

        quotesNumber++;

        System.out.printf("%d번 명언이 등록되었습니다.\n", quotesNumber);
    }
}
