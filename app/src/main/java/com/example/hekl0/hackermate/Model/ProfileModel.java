package com.example.hekl0.hackermate.Model;

import java.util.ArrayList;
import java.util.List;

public class ProfileModel {
    public String image;
    public String name;
    public String school;
    public String major;
    public String hobbies;
    public List<String> hackGoingTo = new ArrayList<>();
    public List<String> willingToDo = new ArrayList<>();
    public List<String> skills = new ArrayList<>();
    public List<Hack> history = new ArrayList<>();

    public ProfileModel() {}

    public ProfileModel(String image, String name, String school, String major, String hobbies, List<String> skills) {
        this.image = image;
        this.name = name;
        this.school = school;
        this.major = major;
        this.hobbies = hobbies;
        this.skills = skills;
    }

    public class Hack {
        public String nameHack;
        public String nameProject;
        public List<String> teamMember;
    }
}
