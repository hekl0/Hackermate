package com.example.hekl0.hackermate.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import com.example.hekl0.hackermate.Activity.SearchSetting;
import com.example.hekl0.hackermate.Adapter.CardstackViewAdapter;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.example.hekl0.hackermate.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.StackFrom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements View.OnClickListener {
    CardStackView cardStackView;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        cardStackView = view.findViewById(R.id.cardstack_view);
        FirebaseDatabase.getInstance().getReference("User List").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<ProfileModel> list = new ArrayList<>();
                for (DataSnapshot snapshot: dataSnapshot.getChildren())
                    list.add(snapshot.getValue(ProfileModel.class));
                CardstackViewAdapter cardstackViewAdapter = new CardstackViewAdapter(list);
                cardStackView.setAdapter(cardstackViewAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        CardStackLayoutManager cardStackLayoutManager = new CardStackLayoutManager(this.getContext());
        cardStackLayoutManager.setStackFrom(StackFrom.Top);
        cardStackView.setLayoutManager(cardStackLayoutManager);

        ImageView iv_setting = view.findViewById(R.id.iv_setting);
        ImageView iv_undo = view.findViewById(R.id.iv_undo);
        ImageView iv_info = view.findViewById(R.id.iv_info);
        ImageView iv_inbox = view.findViewById(R.id.iv_inbox);

        iv_setting.setOnClickListener(this);
        iv_undo.setOnClickListener(this);
        iv_info.setOnClickListener(this);
        iv_inbox.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_undo:
                cardStackView.rewind();
                break;
            case R.id.iv_setting:
                Intent intent = new Intent(getContext(), SearchSetting.class);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_info:
                break;
            case R.id.iv_inbox:
                break;
        }
    }
}
