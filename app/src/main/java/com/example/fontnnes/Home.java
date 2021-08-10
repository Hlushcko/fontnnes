package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void Open_message(View view) {
        Intent button = new Intent(this, Message.class);
        startActivity(button);
    }

    public void Setting(View view) {
        startActivity(new Intent(this, Setting.class));
    }
}