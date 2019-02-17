package com.example.hekl0.hackermate.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hekl0.hackermate.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import info.hoang8f.widget.FButton;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    FirebaseAuth mAuth;
    EditText Email,Password;
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
        Email = findViewById(R.id.username);
        Password = findViewById(R.id.password);


    }

    public boolean checkValid(String email, String password) {
        if(email.length() > 0 && password.length() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_button) {
            if(checkValid(Email.getText().toString(), Password.getText().toString())==true)
            mAuth.signInWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Wrong Username or Password!",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
            else {
                Toast.makeText(LoginActivity.this, "Your Username or Password is Invalid!",
                        Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.signup_button) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}
