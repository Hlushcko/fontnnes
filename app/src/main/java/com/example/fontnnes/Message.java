package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }


    public void Back_home(View view) {
        Intent button = new Intent(this, Home.class);
        startActivity(button);
        startActivity(new Intent(this, Home.class));
    }

    public void OpenChat(){
        startActivity(new Intent(this, Chat.class));
    }

}