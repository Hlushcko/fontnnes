package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Chat extends AppCompatActivity {

    DatabaseLogic DB = new DatabaseLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }


    public void PushMessage(View view) {
        EditText message = findViewById(R.id.TextPeople);
        DB.PushMessagePeople(message.getText().toString());
        message.setText("");
    }
}