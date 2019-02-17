package com.example.hekl0.hackermate.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ConvoModel {
    String idP1;
    String idP2;
    ArrayList<Message> Messages;

    public ConvoModel(String p1, String p2, ArrayList<Message> messages) {
        this.idP1 = p1;
        this.idP2= p2;
        this.Messages = messages;
    }

}
