package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;


public class Register_activity extends AppCompatActivity {

    final private DatabaseLogic DL = new DatabaseLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseApp.initializeApp(this);
    }

    public void LogIn(View view) {
        Intent button = new Intent(this, MainActivity.class);
        startActivity(button);
    }


    public void Registration(View view) {

        TextView email = findViewById(R.id.Text_email);
        TextView password = findViewById(R.id.Text_password);
        TextView password_confirm = findViewById(R.id.Confirm_password);

        DL.Register(email.getText().toString(), password.getText().toString(), password_confirm.getText().toString());
        Toast.makeText(getApplicationContext(), "Check you email", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, MainActivity.class));

    }


}