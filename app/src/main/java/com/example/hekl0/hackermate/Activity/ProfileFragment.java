package com.example.hekl0.hackermate.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hekl0.hackermate.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private ListView listView;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView ava = view.findViewById(R.id.ava);


        Picasso.get()
                .load(R.drawable.logo)
                .transform(new CropCircleTransformation())
                .into(ava);

        String[] hacks = {"BrickHack V", "DandyHack", "BigRedHack"};
//        listView = view.findViewById(R.id.hackathon);
//
//        System.out.print(hacks[0]);
//        DataAdapter adapter = new DataAdapter(hacks);
//        listView.setAdapter(adapter);

        return view;
    }

}
