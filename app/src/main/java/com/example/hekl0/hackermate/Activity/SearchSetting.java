package com.example.hekl0.hackermate.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import com.example.hekl0.hackermate.Adapter.HackathonsAdapter;
import com.example.hekl0.hackermate.Adapter.SkillsAdapter;
import com.example.hekl0.hackermate.R;

public class SearchSetting extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_setting);

        HackathonsAdapter hackathonsAdapter = new HackathonsAdapter();
        GridView gvHackathons = findViewById(R.id.gv_hackathons);
        gvHackathons.setAdapter(hackathonsAdapter);

        SkillsAdapter skillsAdapter = new SkillsAdapter(true);
        GridView gvSkills = findViewById(R.id.gv_skills);
        gvSkills.setAdapter(skillsAdapter);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                finish();
                break;
        }
    }
}
