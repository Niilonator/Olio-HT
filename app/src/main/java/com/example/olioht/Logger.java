package com.example.olioht;


import android.content.Context;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Logger {
    protected String filename;

    public Logger(String name){
        filename = name;
    }



    //takes the log and shoves it into a spinner adapter
    public SpinnerAdapter readlog(Context context){
        SpinnerAdapter adapter;
        FileInputStream fis;
        Scanner scan;
        String s;
        logList log =logList.getInstance();
        try {
            fis = context.openFileInput(filename);
            scan = new Scanner(fis);
            while (scan.hasNextLine()){
                s=scan.nextLine();
                log.append(s);
            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        adapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,log.getlist());
        return  adapter;
    }



    //logs input from user to a logfile
    public void addEntry(Context context,String input) {
        formatter f = formatter.getinstance();
        FileOutputStream fos;

        try {
            fos = context.openFileOutput(filename, context.MODE_PRIVATE);
            fos.write(f.format(input).getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
