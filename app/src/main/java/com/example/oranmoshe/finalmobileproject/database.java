package com.example.oranmoshe.finalmobileproject;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by maoztamir on 06/03/16.
 */
public class database extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this);
        ParseObject oranHabahyan = new ParseObject("oranHabahyan");
        oranHabahyan.put("crying", "alot");
        oranHabahyan.saveInBackground();

    }
}
