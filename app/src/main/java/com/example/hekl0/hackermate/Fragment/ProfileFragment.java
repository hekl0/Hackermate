package com.example.hekl0.hackermate.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.hekl0.hackermate.Activity.ProfileUpdateActivity;
import com.example.hekl0.hackermate.Adapter.HacksAdapter;
import com.example.hekl0.hackermate.Adapter.SkillsAdapter;
import com.example.hekl0.hackermate.R;
import com.example.hekl0.hackermate.Utils.UserDatabase;
import com.squareup.picasso.Picasso;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    ImageView ava;
    TextView name;
    TextView majorSchool;
    TextView hackGoing;
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
        hobbies = view.findViewById(R.id.hobbies);
        skills = view.findViewById(R.id.skills);
        hacks = view.findViewById(R.id.hacks);

        SkillsAdapter skillsAdapter = new SkillsAdapter(false, UserDatabase.profileModel.skills);
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
    public void onResume() {
        super.onResume();
        if (UserDatabase.profileModel.image.length() > 0)
            Picasso.get()
                    .load(UserDatabase.profileModel.image)
                    .transform(new CropCircleTransformation())
                    .into(ava);
        else
            Picasso.get()
                    .load(R.drawable.default_ava)
                    .transform(new CropCircleTransformation())
                    .into(ava);

        name.setText(UserDatabase.profileModel.name);
        majorSchool.setText(UserDatabase.profileModel.major + ", " + UserDatabase.profileModel.school);

        Log.d("xxx", "onCreateView: " + UserDatabase.profileModel.hackGoingTo);
        if (UserDatabase.profileModel.hackGoingTo.size() == 0)
            hackGoing.setText("Just relaxing");
        else {
            String text = "Going to ";
            for (String hack: UserDatabase.profileModel.hackGoingTo)
                text += hack + (UserDatabase.profileModel.hackGoingTo.get(UserDatabase.profileModel.hackGoingTo.size()-1).equals(hack)? "": ", ");
            hackGoing.setText(text);
        }

        hobbies.setText(UserDatabase.profileModel.hobbies);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_setting:
                Intent intent = new Intent(getContext(), ProfileUpdateActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_logout:
                break;
        }
    }
}
