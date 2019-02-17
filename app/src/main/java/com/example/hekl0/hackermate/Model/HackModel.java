package com.example.hekl0.hackermate.Model;

import java.util.List;

public class HackModel {
    public String hackName;
    public String project;
    List<String> team;

    public HackModel(String hackName, String project) {
        this.hackName = hackName;
        this.project = project;
    }
}
