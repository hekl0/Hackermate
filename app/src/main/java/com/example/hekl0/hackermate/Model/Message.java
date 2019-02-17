package com.example.hekl0.hackermate.Model;

public class Message {
    public String Content;
    public boolean IsUser;

    public Message(String s, boolean isUser) {
        this.Content = s;
        this.IsUser = isUser;
    }
}
