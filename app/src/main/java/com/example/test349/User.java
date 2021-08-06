package com.example.test349;

public class User {

    private static String id, email, lname, fname, password;
    private static String date, search, gender, alcohol, smocking, info;

    public User(){}

    public User(String ID, String Email, String Lname, String Fname, String Password){
        id = ID;
        email = Email;
        lname = Lname;
        fname = Fname;
        password = Password;
    }

    public User(String ID, String Date, String Search, String Gender, String Alcohol, String Smocking, String Info){
        id = ID;
        date = Date;
        search = Search;
        gender = Gender;
        alcohol = Alcohol;
        smocking = Smocking;
        info = Info;
    }

    public static String getEmail() {
        return email;
    }

    public static String getLname() {
        return lname;
    }

    public static String getId() {
        return id;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDate() {
        return date;
    }

    public static String getSearch() {
        return search;
    }

    public static void getGender(String gender) {
        User.gender = gender;
    }

    public static String getAlcohol() {
        return alcohol;
    }

    public static String getSmocking() {
        return smocking;
    }

    public static String getInfo() {
        return info;
    }
}
