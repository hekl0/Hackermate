package com.example.hekl0.hackermate.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hekl0.hackermate.Adapter.DataAdapterChatBox;
import com.example.hekl0.hackermate.Model.ChatPerson;
import com.example.hekl0.hackermate.R;

import java.util.ArrayList;
import java.util.List;

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
        List<ChatPerson> CP = new ArrayList<>();
        ListView ChatBoxLV = view.findViewById(R.id.ChatBoxLV);
        for (int i = 0; i <= 10; i++) {
            CP.add(new ChatPerson("The Hacker", " Bro u want to smoke?", "R.mipmap.anhdeptrai"));
        }

        DataAdapterChatBox DACB = new DataAdapterChatBox(this,CP);
        ChatBoxLV.setAdapter(DACB);
        return view;


    }

}
