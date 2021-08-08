package com.example.fontnnes;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseLogic {

    private final DatabaseReference fontnnesDatabaseUserInfo = FirebaseDatabase.getInstance().getReference("User_info");


    public void PushInfoUser(String Lname, String Fname, String Date, String Search, String Gender, String Alcohol, String Smocking, String Info){

       fontnnesDatabaseUserInfo.push().setValue(new User(Lname, Fname, Date, Search, Gender, Alcohol, Smocking, Info));

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
