package com.example.olioht;

import java.time.LocalDate;

public class formatter {
    private static int days; // indicates how many days user has logged
    private static formatter instance;
    private formatter(){
        days=1;
    }
    public static formatter getinstance(){

        if (instance == null){
            instance = new formatter();
        }
        return instance;
    }
    // formats given string into an csv entry
    public String format(String input){
       String s= "Day:"+days+";Weight:"+input+" kg;\n";
       days++;
        return s;
    }
    public int getDays() {
        return days;
    }
}
/* todo: oliolista, oliot jotka listata, mahd muunna csv muotoon,API implementaatio
*   todo2: dokumentaatio, video, repo  */