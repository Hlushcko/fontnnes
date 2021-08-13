package com.example.fontnnes;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class DatabaseLogic extends AppCompatActivity {

    private final DatabaseReference fontnnesDatabaseUserInfo = FirebaseDatabase.getInstance().getReference("User_info");
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private static String email, password, password_confirm;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseApp.initializeApp(this);
    }

    public void Register(String email, String password, String password_confirm){

        Boolean email_boolean = Check_null(email);
        Boolean password_boolean = Check_null(password);

        if (email_boolean && password_boolean){

            if(Objects.equals(password, password_confirm)){

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                                Verification();
                            }
               });
            }
        }
    }


    public void LogIn(String email, String password){
        Boolean boolean_email = Check_null(email);
        Boolean boolean_password = Check_null(password);

        if(boolean_email && boolean_password) {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) { }
            });
        }
    }


    private void Verification(){
        Objects.requireNonNull(auth.getCurrentUser()).sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<Void> task) {

            }
        });
    }

    public boolean CheckLoginUser(){
        FirebaseUser user = auth.getCurrentUser();
        return user != null;
    }

    public boolean CheckEmailVerification(){
        FirebaseUser user = auth.getCurrentUser();
        return Objects.requireNonNull(user).isEmailVerified();
    }

    public void setEmailPasswordPasswordConfirm(String Email, String Password, String Password_confirm){
        email = Email;
        password = Password;
        password_confirm = Password_confirm;
    }



    public void ResetPassword(String email){
        auth.sendPasswordResetEmail(email);
    }

    public void SignOut(){
        FirebaseAuth.getInstance().signOut();
    }

    private Boolean Check_null(String check){
        return !TextUtils.isEmpty(check);
    }


    private static class User {

        private String lname, fname, date, search, gender, alcohol, smocking, info;

        public User(){}

        public User(String Lname, String Fname, String Date, String Search, String Gender, String Alcohol, String Smocking, String Info){

            lname = Lname;
            fname = Fname;
            date = Date;
            search = Search;
            gender = Gender;
            alcohol = Alcohol;
            smocking = Smocking;
            info = Info;
        }

        public String getLname() {
            return lname;
        }

        public String getFname() {
            return fname;
        }

        public String getDate() {
            return date;
        }

        public String getSearch() {
            return search;
        }

        public String getGender() {
            return gender;
        }

        public String getAlcohol() {
            return alcohol;
        }

        public String getSmocking() {
            return smocking;
        }

        public String getInfo() {
            return info;
        }
    }

}
