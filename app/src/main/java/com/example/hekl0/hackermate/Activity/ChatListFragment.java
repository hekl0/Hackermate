package com.example.hekl0.hackermate.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hekl0.hackermate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatListFragment extends Fragment {


    public ChatListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_chat_list, container, false);
        ChatPerson[] CP = new ChatPerson[105];
        for (int i = 0; i < 100; i++) {
            CP[i] = new ChatPerson("loc kun", "bao dep trai", "R.drawable.logo");
        }

        // Inflate the layout for this fragment

        return view;


    }

}
