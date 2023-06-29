package org.example;

import com.google.gson.Gson;

public class Command {
    String cmd;

    public Command fromMethod(String s){
        Gson g = new Gson();
        Command recived = g.fromJson(s,Command.class);
        return recived;
    }

    //{"cmd":"for_man"}
    //{"cmd":"for_woman"}
    //{"cmd":"sorted_by_name"}
    //{"cmd":"sorted_by_price"}
}
