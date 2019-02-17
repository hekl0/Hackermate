package com.example.hekl0.hackermate.Utils;

import android.support.annotation.NonNull;
import android.util.Log;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.google.firebase.database.*;

import java.util.ArrayList;

public class UserDatabase {
    public static String id;

    public static ProfileModel profileModel;

    public static DatabaseReference databaseReference;

    public static void makeProfile(String id, ProfileModel profileModel) {
        UserDatabase.id = id;
        UserDatabase.profileModel = profileModel;

        databaseReference = FirebaseDatabase.getInstance().getReference("User List").child(id);

        updateProfile();
    }

    public static void updateProfile() {
        databaseReference.setValue(profileModel);
    }

    public static void setUserId(String id) {
        UserDatabase.id = id;

        databaseReference = FirebaseDatabase.getInstance().getReference("User List").child(id);
    }
}
