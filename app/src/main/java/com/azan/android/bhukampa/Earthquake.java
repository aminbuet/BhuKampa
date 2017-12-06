package com.azan.android.bhukampa;


/**
 * Created by Aminur Rahman on 6/12/17.
 */

public class Earthquake {

    private String mMagnitude;

    private String mLocation;

    private String mTime;


    public Earthquake (String magnitude, String location, String time){

        mMagnitude = magnitude;
        mLocation = location;
        mTime = time;

    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getTime () {
        return mTime;
    }
}
