package com.ll;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class QuotesData {
    private int index;
    private String autorName;
    private String quote;

    public QuotesData(int index, String autorName, String quote){
        this.index = index;
        this.autorName = autorName;
        this.quote = quote;
    }

    public int getIndex(){
        return index;
    }

    public String getAutorName(){
        return autorName;
    }

    public String getQuote(){
        return quote;
    }
}
