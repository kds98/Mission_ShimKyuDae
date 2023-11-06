package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private String cmd;
    private int quotesNumber = 0;
    private List<String> quotesList = new ArrayList<>();
    private List<String> authorList = new ArrayList<>();
    private List<QuotesData> quotesDataList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");

            cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                System.exit(0);
            } else if (cmd.equals("등록")) {
                createQuotes();
            } else if (cmd.equals("목록")) {
                listView();
            } else if (cmd.startsWith("삭제")) {
                delete();
            }
        }
    }

    private void delete() {
        String[] cmdBits = cmd.split("\\?", 2);
        String[] cmdBitsArray = cmdBits[1].split("=");
        int deleteId = Integer.parseInt(cmdBitsArray[1]);

//        System.out.println(cmdBitsArray[1]);
        try {
//            quotesList.remove(Integer.parseInt(cmdBitsArray[1]) - 1);
//            authorList.remove(Integer.parseInt(cmdBitsArray[1]) - 1);
            if(quotesDataList.get(deleteId - 1).getIndex() == deleteId){
                quotesDataList.remove(deleteId - 1);
                System.out.printf("%d번 명언이 삭제되었습니다.\n", deleteId);
            }

        } catch (IndexOutOfBoundsException e){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", deleteId);
        }
//        quotesList.remove(Integer.parseInt(cmdBitsArray[1]) - 1);
//        authorList.remove(Integer.parseInt(cmdBitsArray[1]) - 1);
//        System.out.printf("%s번 명언이 삭제되었습니다.\n", cmdBitsArray[1]);
    }

    private void listView() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = quotesDataList.size() - 1; i >= 0; i--) {
            System.out.printf("%d / %s / %s\n", quotesDataList.get(i).getIndex(), quotesDataList.get(i).getAutorName(), quotesDataList.get(i).getQuote());
        }
    }

    private void createQuotes() {

        System.out.print("명언 : ");
        String quotes = scanner.nextLine();
//        quotesList.add(scanner.nextLine());

        System.out.print("작가 : ");
        String author = scanner.nextLine();
//        authorList.add(scanner.nextLine());
        quotesNumber++;
        quotesDataList.add(new QuotesData(quotesNumber, quotes, author));


        System.out.printf("%d번 명언이 등록되었습니다.\n", quotesNumber);
    }
}
