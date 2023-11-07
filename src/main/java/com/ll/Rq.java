package com.ll;

import java.util.Scanner;

public class Rq {
    private String cmd;
    Scanner scanner = new Scanner(System.in);
    public void Rq(String cmd){

    }

    public void inputCmd() {
        cmd = scanner.nextLine();
    }

    public String getCmd(){
        return this.cmd;
    }

    public int getParseIntCmd() {
        String[] cmdBits = cmd.split("\\?", 2);
        String[] cmdBitsArray = cmdBits[1].split("=");
//        int deleteId = Integer.parseInt(cmdBitsArray[1]);
        return Integer.parseInt(cmdBitsArray[1]);
    }
}
