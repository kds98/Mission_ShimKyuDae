package com.ll;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuotesData {
    @JsonProperty("id")
    private int index;
    @JsonProperty("author")
    private String authorName;
    @JsonProperty("content")
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
        int index = Integer.parseInt(parts[0]);
        String authorName = parts[1];
        String quote = parts[2];
        return new QuotesData(index, authorName, quote);
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
