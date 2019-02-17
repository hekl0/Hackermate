package com.example.hekl0.hackermate.Activity;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import android.widget.Toast;
import com.example.hekl0.hackermate.Adapter.SkillsAdapter;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.example.hekl0.hackermate.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import info.hoang8f.widget.FButton;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignUpActivity";

    EditText email;
    EditText password;
    EditText confirmPassword;
    EditText yourName;
    EditText yourSchool;
    EditText yourMajor;
    EditText yourHobbies;

    FirebaseAuth mAuth;

    SkillsAdapter skillsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        yourName = findViewById(R.id.your_name);
        yourSchool = findViewById(R.id.your_school);
        yourMajor = findViewById(R.id.your_major);
        yourHobbies = findViewById(R.id.your_hobbie);

        skillsAdapter = new SkillsAdapter(true);
        GridView gvSkills = findViewById(R.id.SignUpSkills);
        gvSkills.setAdapter(skillsAdapter);
        FButton signupButton = findViewById(R.id.signup_button);
        signupButton.setButtonColor(Color.parseColor("#2ecc71"));
        signupButton.setCornerRadius(60);
        signupButton.setOnClickListener(this);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
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
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                                    makeAccount(firebaseUser.getUid());
                                    Toast.makeText(getBaseContext(), "Register Success", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else
                                    Toast.makeText(getBaseContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
        }
    }

    void makeAccount(String id) {
        List<String> skills = new ArrayList<>();
        for (int i = 0; i < skillsAdapter.checkItem.length; i++)
            if (skillsAdapter.checkItem[i])
                skills.add(skillsAdapter.listSkills.get(i));

        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("User List");
        firebaseDatabase.child(id).setValue(
                new ProfileModel("",
                        yourName.getText().toString(),
                        yourSchool.getText().toString(),
                        yourMajor.getText().toString(),
                        yourHobbies.getText().toString(),
                        skills));
    }

    private boolean checkValidInfo() {
        boolean valid = true;

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
        if (yourHobbies.getText().toString().length() == 0) {
            yourHobbies.setError("Please share your hobbies");
            valid = false;
        }

        return valid;
    }
}
