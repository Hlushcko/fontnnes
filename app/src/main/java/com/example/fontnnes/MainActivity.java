package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    DatabaseLogic DB = new DatabaseLogic();
    private TextView email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CheckVerification();
        FirebaseApp.initializeApp(this);
    }

    public void Registers(View view) {
        startActivity(new Intent(this, Register_activity.class));
    }

    public void LogIn(View view) {

        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);

        DB.LogIn(email.getText().toString(), password.getText().toString());

        if(DB.CheckLoginUser()){
            startActivity(new Intent(this, Home.class));
        }
    }

    private void CheckVerification(){
        if(DB.CheckLoginUser() && DB.CheckEmailVerification()){
            startActivity(new Intent(this, Home.class));
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void setPassword(View view) {
        startActivity(new Intent(this, reset_password.class));
    }
}