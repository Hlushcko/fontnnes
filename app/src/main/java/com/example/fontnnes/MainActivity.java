package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {


    private TextView email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
    }

    public void Registers(View view) {
        Intent button = new Intent(this, Register_activity.class);
        startActivity(button);
    }

    public void LogIn(View view) {

        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);

        Intent button = new Intent(this, Home.class);
        startActivity(button);

    }
}