package com.example.hekl0.hackermate.Model;

import java.util.List;

public class ProfileModel {
    public String image;
    public String name;
    public String school;
    public String major;
    public List<String> hackGoingTo;
    public List<String> willingToDo;
    public List<String> skills;
    public List<Hack> history;

    public ProfileModel(String image, String name, String school, String major) {
        this.image = image;
        this.name = name;
        this.school = school;
        this.major = major;
    }

    public class Hack {
        public String nameHack;
        public String nameProject;
        public List<String> teamMember;
    }
}
