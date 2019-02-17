package com.example.hekl0.hackermate.Activity;

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
import info.hoang8f.widget.FButton;

public class ProfileUpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignUpActivity";

    EditText username;
    EditText email;
    EditText password;
    EditText confirmPassword;
    EditText yourName;
    EditText yourSchool;
    EditText yourMajor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        yourName = findViewById(R.id.your_name);
        yourSchool = findViewById(R.id.your_school);
        yourMajor = findViewById(R.id.your_major);

        SkillsAdapter skillsAdapter = new SkillsAdapter(true);
        GridView gvSkills = findViewById(R.id.SignUpSkills);
        gvSkills.setAdapter(skillsAdapter);
        FButton signupButton = findViewById(R.id.signup_button);
        signupButton.setButtonColor(Color.parseColor("#2ecc71"));
        signupButton.setCornerRadius(60);
        signupButton.setOnClickListener(this);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);
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
                break;
        }
    }

    private boolean checkValidInfo() {
        boolean valid = true;

        if (username.getText().toString().length() < 6) {
            username.setError("Username must be at least 6 characters long");
            valid = false;
        }

        if (!email.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            email.setError("Invalid email address");
            valid = false;
        }
        if (password.getText().toString().length() < 6) {
            password.setError("Password must be at least 6 characters long");
            valid = false;
        }

        if (!confirmPassword.getText().toString().equals(password.getText().toString())) {
            confirmPassword.setError("Doesn't match with password above");
            valid = false;
        }

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
