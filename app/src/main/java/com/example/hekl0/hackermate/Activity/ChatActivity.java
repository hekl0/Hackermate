package com.example.hekl0.hackermate.Activity;

import com.example.hekl0.hackermate.Adapter.DataAdapterChatBox;
import com.example.hekl0.hackermate.Adapter.DataAdapterInBox;
import com.example.hekl0.hackermate.Model.ConvoModel;
import com.example.hekl0.hackermate.Model.Message;
import com.example.hekl0.hackermate.R;
import com.example.hekl0.hackermate.Utils.UserDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import java.util.ArrayList;
import java.util.List;


public class ChatActivity extends AppCompatActivity {
    public String HeaderImgSrc;
    private DatabaseReference dtfb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        //dtfb = FirebaseDatabase.getInstance().getReference().child("Chat List").child(chatId);
        List<Message> messages = new ArrayList<>();
        ListView ult2 = findViewById(R.id.lv);
        ImageView Avatar = findViewById(R.id.avatar);
        List<String> ChatList = UserDatabase.profileModel.chatList;
        Picasso.get()
                .load(DataAdapterChatBox.src)
                .transform(new CropCircleTransformation())
                .into(Avatar);
        ImageView back = findViewById(R.id.backbtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ChatActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
        DataAdapterInBox DAIB = new DataAdapterInBox(this, messages);
        ult2.setAdapter(DAIB);
    }
}
