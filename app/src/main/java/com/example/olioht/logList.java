package com.example.olioht;

import java.util.ArrayList;

public class logList {
    private ArrayList<String> list;
    private static logList instance;

    private logList() {
        list = new ArrayList<String>();
    }

    public static logList getInstance() {
        if (instance == null) {
            instance = new logList();
        }
        return instance;
    }

    public void append(String s) {
        list.add(s);
    }

    public String read(int j) {
        String s;
        s = list.get(j);
        return s;
    }

    public ArrayList<String> getlist() {
        return list;
    }


}

