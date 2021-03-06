package com.example.hekl0.hackermate.Model;

import java.util.ArrayList;
import java.util.List;

public class ProfileModel {
    public String id;
    public String image;
    public String name;
    public String school;
    public String major;
    public String hobbies;
    public List<String> hackGoingTo = new ArrayList<>();
    public List<String> skills = new ArrayList<>();
    public List<Hack> history = new ArrayList<>();
    public List<String> chatList = new ArrayList<>();


    public ProfileModel() {
    }

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

    public class ChatModel {
        String p2, id;

        public ChatModel(String P2, String id) {
            this.p2 = P2;
            this.id = id;
        }
    }
}
