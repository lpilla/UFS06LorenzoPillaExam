package org.example;

import com.google.gson.Gson;

import java.util.List;

public class Answer {
    boolean result;
    String msg;
    List<Shoe> shoes;
    Shoe shoe;

    public Answer(boolean result, List<Shoe> shoes) {
        this.result = result;
        this.shoes = shoes;
    }

    public Answer(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public Answer(boolean result, Shoe shoe) {
        this.result = result;
        this.shoe = shoe;
    }


    public String answerJSON(){
        Gson g = new Gson();
        String s = g.toJson(this);
        return s;
    }
}
