package com.example.hekl0.hackermate.Utils;

import android.support.annotation.NonNull;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.google.firebase.database.*;

import java.util.ArrayList;

public class UserDatabase {
    public static UserDatabase userDatabase;
    public static String id;

    public ProfileModel profileModel;

    static DatabaseReference databaseReference;

    public static UserDatabase getInstance() {
        return userDatabase;
    }

    public static void setUserId(String id) {
        if (userDatabase == null)
            userDatabase = new UserDatabase();

        UserDatabase.id = id;

        databaseReference = FirebaseDatabase.getInstance().getReference("User List").child(id);
        userDatabase.accessUser();
    }

    private void accessUser() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                profileModel = dataSnapshot.getValue(ProfileModel.class);
                if (profileModel.hackGoingTo == null)
                    profileModel.hackGoingTo = new ArrayList<>();
                if (profileModel.willingToDo == null)
                    profileModel.willingToDo = new ArrayList<>();
                if(profileModel.skills == null)
                    profileModel.skills = new ArrayList<>();
                if (profileModel.history == null)
                    profileModel.history = new ArrayList<>();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
