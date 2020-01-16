package com.divij.srmpharmacy;

import android.app.Application;

import com.firebase.client.Firebase;

public class srmpharmacy extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);


    }
}
