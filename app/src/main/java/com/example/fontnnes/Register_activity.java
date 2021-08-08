package com.example.fontnnes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.Context;

import org.w3c.dom.Text;


public class Register_activity extends AppCompatActivity {

    TextView email, password, password_confirm;
    DatabaseLogic DL = new DatabaseLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void LogIn(View view) {
        Intent button = new Intent(this, MainActivity.class);
        startActivity(button);
    }


    public void Registration(View view) {

        email = findViewById(R.id.Text_email);
        password = findViewById(R.id.Text_password);
        password_confirm = findViewById(R.id.Confirm_password);

        DL.SingIn(email, password, password_confirm);
    }


}