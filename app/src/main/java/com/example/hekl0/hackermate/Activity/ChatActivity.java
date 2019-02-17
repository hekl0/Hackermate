package com.example.hekl0.hackermate.Activity;

import com.example.hekl0.hackermate.Adapter.DataAdapterInBox;
import com.example.hekl0.hackermate.Model.Chat;
import com.example.hekl0.hackermate.R;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        List<Chat> s = new ArrayList<>();
        ListView ult2 =   findViewById(R.id.lv);
        ImageView Avatar = findViewById(R.id.avatar);
        Picasso.get()
                .load(R.mipmap.anhdeptrai)
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
        DataAdapterInBox DAIB = new DataAdapterInBox(this,s);
        ult2.setAdapter(DAIB);
    }
}
