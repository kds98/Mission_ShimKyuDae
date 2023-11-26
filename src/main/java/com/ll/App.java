package com.ll;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.*;

public class App {
    Rq rq = new Rq();
    ObjectMapper objectMapper = new ObjectMapper();
    private int quotesNumber = 0;
    final private List<QuotesData> quotesDataList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        readFile();

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");

            rq.inputCmd();

            if (rq.getCmd().equals("종료")) {
                createFile();
                System.exit(0);
            } else if (rq.getCmd().equals("등록")) {
                createQuotes();
            } else if (rq.getCmd().equals("목록")) {
                listView();
            } else if (rq.getCmd().startsWith("삭제")) {
                delete();

            } else if (rq.getCmd().startsWith("수정")) {
                modify();
            } else if (rq.getCmd().equals("빌드")) {
                try {
                    ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
                    writer.writeValue(new File("data.json"), quotesDataList);
                    System.out.println("data.json 파일의 내용이 갱신되었습니다.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                QuotesData quotesData = QuotesData.fromString(line);
                quotesDataList.add(quotesData);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        int deleteId = rq.getParseIntCmd();
        int index = getIndexQuotesDataList(deleteId);

        if (index == -1) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", deleteId);
        } else {
            quotesDataList.remove(index);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", deleteId);
        }

    }

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

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        quotesNumber++;
        quotesDataList.add(new QuotesData(quotesNumber, author, quotes));

        System.out.printf("%d번 명언이 등록되었습니다.\n", quotesNumber);
    }

    private void createFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            for (QuotesData item : quotesDataList) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
