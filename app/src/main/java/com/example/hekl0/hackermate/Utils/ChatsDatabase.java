package com.example.hekl0.hackermate.Utils;

import android.support.annotation.NonNull;
import android.util.Log;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.google.firebase.database.*;

import java.util.ArrayList;

public class ChatsDatabase {
    public static String id;

    public static ProfileModel profileModel;

    static DatabaseReference databaseReference;

    public static void makeNewChat(String id, ProfileModel profileModel) {
        UserDatabase.id = id;
        UserDatabase.profileModel = profileModel;

        databaseReference = FirebaseDatabase.getInstance().getReference("Chat List").child(id);

        updateProfile();
    }

    public static void updateProfile() {
        databaseReference.setValue(profileModel);
    }

    public static void setUserId(String id) {
        UserDatabase.id = id;

        databaseReference = FirebaseDatabase.getInstance().getReference("User List").child(id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("xxx", "onDataChange: " + dataSnapshot);
                profileModel = dataSnapshot.getValue(ProfileModel.class);
                if (profileModel.hackGoingTo == null)
                    profileModel.hackGoingTo = new ArrayList<>();
                if (profileModel.willingToDo == null)
                    profileModel.willingToDo = new ArrayList<>();
                if(profileModel.skills == null)
                    profileModel.skills = new ArrayList<>();
                if (profileModel.history == null)
                    profileModel.history = new ArrayList<>();
                if (profileModel.chatList == null)
                    profileModel.chatList = null;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
