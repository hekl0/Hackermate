package com.example.hekl0.hackermate.Model;

public class ChatPerson {
    public String Name, LastMess, Source;

    public ChatPerson (String name,String lastMess, String src) {
        this.Source = src;
        this.Name = name;
        this.LastMess = lastMess;
    }
}
