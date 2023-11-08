package com.ll;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class QuotesData {
    private int index;
    private String authorName;
    private String quote;

    public QuotesData(int index, String authorName, String quote) {
        this.index = index;
        this.authorName = authorName;
        this.quote = quote;
    }

    @Override
    public String toString() {
        return index + " / " + authorName + " / " + quote;
    }

    public static QuotesData fromString(String s) {
        String[] parts = s.split(" / ");
        int number = Integer.parseInt(parts[0]);
        String text1 = parts[1];
        String text2 = parts[2];
        return new QuotesData(number, text1, text2);
    }

    public int getIndex() {
        return index;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
