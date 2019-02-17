package com.example.hekl0.hackermate.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import com.example.hekl0.hackermate.Adapter.HackathonsAdapter;
import com.example.hekl0.hackermate.R;

public class SearchSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_setting);

        HackathonsAdapter hackathonsAdapter = new HackathonsAdapter();
        GridView gvHackathons = findViewById(R.id.gv_hackathons);
        gvHackathons.setAdapter(hackathonsAdapter);

        GridView gvSkills = findViewById(R.id.gv_skills);
    }
}
