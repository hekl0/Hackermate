package com.example.hekl0.hackermate.Activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hekl0.hackermate.R;

public class ChatListFragment extends Fragment {


    public ChatListFragment() {
        // Required empty public constructor
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_list, container, false);
        ChatPerson[] CP = new ChatPerson[105];
        for (int i = 1; i <= 100; i++) {
            CP[i] = new ChatPerson("The Hacker", " Bro u want to smoke?", "R.mipmap.anhdeptrai");
        }
        return view;

    }

}
