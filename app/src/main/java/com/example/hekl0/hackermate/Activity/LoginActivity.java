package com.example.hekl0.hackermate.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.hekl0.hackermate.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import info.hoang8f.widget.FButton;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FButton loginButton = (FButton) findViewById(R.id.login_button);
        loginButton.setCornerRadius(60);
        loginButton.setOnClickListener(this);

        TextView signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword("sathubian1999@gmail.com", "1234560")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    }
                });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        Log.d(TAG, "onComplete: ok " + myRef);

        myRef.setValue("Hello, World!");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_button) {
            Log.d(TAG, "onClick: login button");
        }
        if (v.getId() == R.id.signup_button) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}
