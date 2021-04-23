package com.example.olioht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Adapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
Context context;
Logger log;
String filename = "log.csv";
TextView etv,etv2,results;
Spinner spinner;
SpinnerAdapter adapter;
CoTwo co;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        context = this;
        log = new Logger(filename);
        etv = findViewById(R.id.editTextNumber);
        spinner = findViewById(R.id.spinner2);
        etv2 = findViewById(R.id.editTextNumber2);
        results = findViewById(R.id.textView2);
    }

    public void saveEntry(View v){
        String s = etv.getText().toString();
        log.addEntry(context,s);

    }
    public void readlog(View e){
        adapter =log.readlog(context);
        spinner.removeAllViewsInLayout();
        spinner.setAdapter(adapter);
    }
    public void CoQuery(View f){
        String s = etv2.getText().toString();
        co = new CoTwo(s);
        co.queryCoTwo();
        Double d = co.getResult();
        CharSequence cs = String.format("%f",d);
        results.setText(cs);
    }
}