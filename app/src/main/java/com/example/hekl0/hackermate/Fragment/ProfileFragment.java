package com.example.hekl0.hackermate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hekl0.hackermate.Adapter.HacksAdapter;
import com.example.hekl0.hackermate.Adapter.SkillsAdapter;
import com.example.hekl0.hackermate.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    ImageView ava;
    TextView name;
    TextView majorSchool;
    TextView hackGoing;
    TextView projectWanting;
    TextView hobbies;
    GridView skills;
    ListView hacks;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ava = view.findViewById(R.id.ava);
        name = view.findViewById(R.id.name);
        majorSchool = view.findViewById(R.id.major_and_school);
        hackGoing = view.findViewById(R.id.hack_going);
        projectWanting = view.findViewById(R.id.project_wanting);
        hobbies = view.findViewById(R.id.hobbies);
        skills = view.findViewById(R.id.skills);
        hacks = view.findViewById(R.id.hacks);

        Picasso.get()
                .load(R.drawable.temp)
                .transform(new CropCircleTransformation())
                .into(ava);

        SkillsAdapter skillsAdapter = new SkillsAdapter(false);
        skills.setAdapter(skillsAdapter);

        HacksAdapter hacksAdapter = new HacksAdapter();
        hacks.setAdapter(hacksAdapter);

        ImageView setting = view.findViewById(R.id.iv_setting);
        setting.setOnClickListener(this);
        ImageView logout = view.findViewById(R.id.iv_logout);
        logout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_setting:
                break;
            case R.id.iv_logout:
                break;
        }
    }
}
