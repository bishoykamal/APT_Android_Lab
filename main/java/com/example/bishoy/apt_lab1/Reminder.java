package com.example.bishoy.apt_lab1;

/**
 * Created by bishoy on 5/2/18.
 */

public class Reminder {
   public String text;
   public boolean important;

    public Reminder(){

    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }
}
