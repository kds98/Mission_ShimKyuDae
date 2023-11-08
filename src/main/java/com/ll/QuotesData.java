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
