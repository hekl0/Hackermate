package com.example.hekl0.hackermate.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.hekl0.hackermate.Adapter.SkillsAdapter;
import com.example.hekl0.hackermate.R;
import com.example.hekl0.hackermate.Utils.UserDatabase;
import com.squareup.picasso.Picasso;

import info.hoang8f.widget.FButton;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ProfileUpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignUpActivity";
    EditText yourName;
    EditText yourSchool;
    EditText yourMajor;
    EditText yourHobbies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        yourName = findViewById(R.id.your_name);
        yourSchool = findViewById(R.id.your_school);
        yourMajor = findViewById(R.id.your_major);
        yourHobbies = findViewById(R.id.your_hobbie);
        ImageView ava = findViewById(R.id.ProfileAvatar);
        Picasso.get()
                .load(R.drawable.default_ava)
                .transform(new CropCircleTransformation())
                .into(ava);

        SkillsAdapter skillsAdapter = new SkillsAdapter(true);
        GridView gvSkills = findViewById(R.id.SignUpSkills);
        gvSkills.setAdapter(skillsAdapter);
        FButton signupButton = findViewById(R.id.signup_button);
        signupButton.setButtonColor(Color.parseColor("#2ecc71"));
        signupButton.setCornerRadius(60);
        signupButton.setOnClickListener(this);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        yourName.setText(UserDatabase.profileModel.name);
        yourSchool.setText(UserDatabase.profileModel.school);
        yourMajor.setText(UserDatabase.profileModel.major);
        yourHobbies.setText(UserDatabase.profileModel.hobbies);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.signup_button:
                if (!checkValidInfo())
                    return;
                Log.d(TAG, "onClick: valid info");
                UserDatabase.profileModel.name = yourName.getText().toString();
                UserDatabase.profileModel.school = yourSchool.getText().toString();
                UserDatabase.profileModel.major = yourMajor.getText().toString();
                UserDatabase.profileModel.hobbies = yourHobbies.getText().toString();
                UserDatabase.updateProfile();
                finish();
                break;
        }
    }

    private boolean checkValidInfo() {
        boolean valid = true;

        if (yourName.getText().toString().length() == 0) {
            yourName.setError("Can't be empty");
            valid = false;
        }

        if (yourSchool.getText().toString().length() == 0) {
            yourSchool.setError("Can't be empty");
            valid = false;
        }
        if (yourMajor.getText().toString().length() == 0) {
            yourMajor.setError("Can't be empty");
            valid = false;
        }

        return valid;
    }
}
