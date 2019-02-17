package com.example.hekl0.hackermate.Activity;

import com.example.hekl0.hackermate.R;
import com.squareup.picasso.Picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;


public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        String ran = new String("dsdnjsbdsndsdFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        Chat[] s = new Chat[100];
        ListView ult2 =   findViewById(R.id.lv);
        ImageView Avatar = findViewById(R.id.avatar);
        Picasso.get()
                .load(R.mipmap.anhdeptrai)
                .transform(new CropCircleTransformation())
                .into(Avatar);
        for (int i = 0; i < 100; i++) {
            s[i] = new Chat(ran,i%2);
        }
        DataAdapterInBox DAIB = new DataAdapterInBox(this,s);
        ult2.setAdapter(DAIB);
    }
}
