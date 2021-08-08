package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

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

        DatabaseLogic DB = new DatabaseLogic();
        //DB.PushInfoUser();

    }
}