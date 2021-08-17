package com.example.fontnnes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;

public class reset_password extends AppCompatActivity {

    DatabaseLogic DB = new DatabaseLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
    }

    public void Reset(View view) {

        EditText email = findViewById(R.id.Email_reset);
        String gmail = email.getText().toString();

        if(!gmail.isEmpty()) {
            email.setText("");
            DB.ResetPassword(gmail);
            Toast.makeText(this, "Place, check you email " + gmail, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText( this, "Error, make sure you filled in everything correctly ", Toast.LENGTH_SHORT).show();
        }
    }

    public void Back_main(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}