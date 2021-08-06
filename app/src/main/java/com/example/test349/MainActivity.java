package com.example.test349;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Context;

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

        //private final DatabaseReference fontnnesDatabaseUser = FirebaseDatabase.getInstance().getReference("User");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        //DatabaseLogic DB = new DatabaseLogic();
        //DB.PushInfoUser("vova@gmail.com", "vova", "hluchko", "lol12345");
        //DB.PushDetailedInfoUser("2002/09/16", "friends", "male", "no", "no", "i love cookie");
    }
}