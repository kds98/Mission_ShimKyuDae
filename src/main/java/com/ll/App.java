package com.ll;

import java.util.*;

public class App {
    Rq rq = new Rq();
//    private String cmd;
    private int quotesNumber = 0;
//    private List<String> quotesList = new ArrayList<>();
//    private List<String> authorList = new ArrayList<>();
    final private List<QuotesData> quotesDataList = new ArrayList<>();
    //    Map<Integer, QuotesData> quotesDataList = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");

//            cmd = scanner.nextLine();
            rq.inputCmd();

            if (rq.getCmd().equals("종료")) {
                System.exit(0);
            } else if (rq.getCmd().equals("등록")) {
                createQuotes();
            } else if (rq.getCmd().equals("목록")) {
                listView();
            } else if (rq.getCmd().startsWith("삭제")) {
                delete();
            } else if (rq.getCmd().startsWith("수정")) {
                modify();
            }
        }
    }

    private void modify() {
        int modifyId = rq.getParseIntCmd();
        int index = getIndexQuotesDataList(modifyId);
        System.out.println("명언)(기존) : " + quotesDataList.get(index).getQuote());
        System.out.print("명언 : ");
        String modifyQuotes = scanner.nextLine();
        QuotesData quotesData = quotesDataList.get(index);
        quotesData.setQuote(modifyQuotes);
        System.out.println("작가)(기존) : " + quotesDataList.get(index).getAuthorName());
        System.out.print("작가 : ");
        String modifyAuthorName = scanner.nextLine();
        quotesData.setAuthorName(modifyAuthorName);
    }

    private int getIndexQuotesDataList(int id) {
        for (int i = 0; i < quotesDataList.size(); i++) {
            QuotesData quotesData = quotesDataList.get(i);

            if (quotesData.getIndex() == id) {
                return i;
            }
        }
        return -1;
    }


    private void delete() {
//        String[] cmdBits = rq.getCmd().split("\\?", 2);
//        String[] cmdBitsArray = cmdBits[1].split("=");
        int deleteId = rq.getParseIntCmd();
        int index = getIndexQuotesDataList(deleteId);

//        System.out.println(cmdBitsArray[1]);

//            quotesList.remove(Integer.parseInt(cmdBitsArray[1]) - 1);
//            authorList.remove(Integer.parseInt(cmdBitsArray[1]) - 1);
        if (index == -1) {

            System.out.printf("%d번 명언은 존재하지 않습니다.\n", deleteId);
        } else {
            quotesDataList.remove(index);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", deleteId);
        }

    }
//        quotesList.remove(Integer.parseInt(cmdBitsArray[1]) - 1);
//        authorList.remove(Integer.parseInt(cmdBitsArray[1]) - 1);
//        System.out.printf("%s번 명언이 삭제되었습니다.\n", cmdBitsArray[1]);


    private void listView() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = quotesDataList.size() - 1; i >= 0; i--) {
            System.out.printf("%d / %s / %s\n", quotesDataList.get(i).getIndex(), quotesDataList.get(i).getAuthorName(), quotesDataList.get(i).getQuote());
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
        quotesDataList.add(new QuotesData(quotesNumber, author, quotes));

        System.out.printf("%d번 명언이 등록되었습니다.\n", quotesNumber);
    }
}
