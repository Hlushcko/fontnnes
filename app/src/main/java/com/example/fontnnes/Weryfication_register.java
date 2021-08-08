package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Weryfication_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weryfication_register);
    }

    public void BackRegister(View view) {
        Intent intent = new Intent(this, Register_activity.class);
        startActivity(intent);
    }
}