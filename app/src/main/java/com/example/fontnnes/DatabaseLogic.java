package com.example.fontnnes;

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


public class DatabaseLogic extends AppCompatActivity {

    private final DatabaseReference fontnnesDatabaseUserInfo = FirebaseDatabase.getInstance().getReference("User_info");
    private FirebaseAuth auth = FirebaseAuth.getInstance();

    public void PushInfoUser(String Lname, String Fname, String Date, String Search, String Gender, String Alcohol, String Smocking, String Info){

       fontnnesDatabaseUserInfo.push().setValue(new User(Lname, Fname, Date, Search, Gender, Alcohol, Smocking, Info));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseApp.initializeApp(this);

        FirebaseUser DBuser = auth.getCurrentUser();

        if(DBuser == null){
            Toast.makeText(this, "user null", Toast.LENGTH_SHORT).show();
        }
    }

    public void SingIn(TextView email, TextView password,TextView password_confirm){

        Boolean email_boolean = Check_null(email);
        Boolean password_boolean = Check_null(password);
        Boolean confirm_password_boolean = Check_null(password_confirm);

        if (email_boolean & password_boolean & confirm_password_boolean){

            if(password == password_confirm){

                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    Toast.makeText(getApplication().getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }else{
                Toast.makeText(this, "Password mismatch", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean Check_null(TextView view){

        if (TextUtils.isEmpty(view.getText().toString())){
            return false;
        } else{
            return true;
        }
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
