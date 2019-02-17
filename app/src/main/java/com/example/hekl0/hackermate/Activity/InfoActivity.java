package com.example.hekl0.hackermate.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.hekl0.hackermate.Adapter.CardstackViewAdapter;
import com.example.hekl0.hackermate.Adapter.HacksAdapter;
import com.example.hekl0.hackermate.Adapter.SkillsAdapter;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.example.hekl0.hackermate.R;
import com.example.hekl0.hackermate.Utils.UserDatabase;
import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackView;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class InfoActivity extends AppCompatActivity {
    ImageView ava;
    TextView name;
    TextView majorSchool;
    TextView hackGoing;
    TextView hobbies;
    GridView skills;
    ListView hacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Log.d("lox", "onCreate: " + getIntent().getExtras().getInt("key"));
        ProfileModel profileModel = CardstackViewAdapter.profileModelList.get(getIntent().getExtras().getInt("key"));

        ava = findViewById(R.id.ava);
        name = findViewById(R.id.name);
        majorSchool = findViewById(R.id.major_and_school);
        hackGoing = findViewById(R.id.hack_going);
        hobbies = findViewById(R.id.hobbies);
        skills = findViewById(R.id.skills);
        hacks = findViewById(R.id.hacks);

        if (profileModel.image.length() > 0)
            Picasso.get()
                    .load(profileModel.image)
                    .transform(new CropCircleTransformation())
                    .into(ava);
        else
            Picasso.get()
                    .load(R.drawable.default_ava)
                    .transform(new CropCircleTransformation())
                    .into(ava);

        name.setText(profileModel.name);
        majorSchool.setText(profileModel.major + ", " + profileModel.school);

        Log.d("xxx", "onCreateView: " + profileModel.hackGoingTo);
        if (profileModel.hackGoingTo.size() == 0)
            hackGoing.setText("Just relaxing");
        else {
            String text = "Going to ";
            for (String hack : profileModel.hackGoingTo)
                text += hack + (profileModel.hackGoingTo.get(profileModel.hackGoingTo.size() - 1).equals(hack) ? "" : ", ");
            hackGoing.setText(text);
        }

        hobbies.setText(profileModel.hobbies);

        SkillsAdapter skillsAdapter = new SkillsAdapter(false, profileModel.skills);
        skills.setAdapter(skillsAdapter);

        HacksAdapter hacksAdapter = new HacksAdapter();
        hacks.setAdapter(hacksAdapter);

        ImageView back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
