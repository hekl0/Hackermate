package com.example.hekl0.hackermate.Activity;

import com.example.hekl0.hackermate.Adapter.DataAdapter;
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
import android.widget.TextView;

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
        final List<Message> messages = new ArrayList<>();
        ListView ult2 = findViewById(R.id.lv);
        ImageView Avatar = findViewById(R.id.avatar);
        List<String> ChatList = UserDatabase.profileModel.chatList;
        Picasso.get()
                .load(DataAdapterChatBox.src)
                .transform(new CropCircleTransformation())
                .into(Avatar);
        if(DataAdapterChatBox.src.equals(DataAdapterChatBox.src1)) {
            messages.add(new Message("Hey, u want to join my team?",true));
            messages.add(new Message("Okay",false));
            messages.add(new Message("But to make sure i am not really good with android!",false));
        }
        ImageView back = findViewById(R.id.backbtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        final DataAdapterInBox DAIB = new DataAdapterInBox(this, messages);
        ult2.setAdapter(DAIB);
        final TextView input = findViewById(R.id.inputTextField);

        ImageView Send = findViewById(R.id.iv_send);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataAdapterInBox.items.add(new Message(input.getText().toString(), true));
                DAIB.notifyDataSetChanged();
                input.setText("");
            }
        });
    }
}
