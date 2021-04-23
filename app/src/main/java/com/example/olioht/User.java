package com.example.olioht;

public class User {
   protected String passw;
   protected String name;

   User(String un,String pw){
        passw = pw;
        name = un;
    }

    public String getName() {
        return name;
    }

    public String getPassW() {
        return passw;
    }


}

