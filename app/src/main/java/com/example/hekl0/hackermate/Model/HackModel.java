package com.example.hekl0.hackermate.Model;

import java.util.List;

public class HackModel {
    public String hackName;
    public String project;
    public List<String> team;

    public HackModel(String hackName, String project, List<String> team) {
        this.hackName = hackName;
        this.project = project;
        this.team = team;
    }
}
