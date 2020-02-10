package com.divij.srmpharmacy;

import android.telecom.Call;

import java.util.HashMap;

public class User_List {

    private HashMap<String,String> Name;

    private HashMap<String,String> value;


    public User_List(HashMap<String,String>Name, HashMap<String, String>value) {

        Name = Name;
        value= value;
    }

    public HashMap<String, String> getName() {
        return Name;
    }

    public HashMap<String, String> getvalue() {
        return value;
    }
}

