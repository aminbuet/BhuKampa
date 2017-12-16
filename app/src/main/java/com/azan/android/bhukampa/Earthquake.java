package com.azan.android.bhukampa;


/**
 * Created by Aminur Rahman on 6/12/17.
 */

public class Earthquake {

    private String mMagnitude;

    private String mLocation;

    // time of earthquake
    private long mTimeInMilliseconds;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *  earthquake happened
     */
    public Earthquake (String magnitude, String location, long timeInMilliseconds){

        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;

    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds () {
        return mTimeInMilliseconds;
    }
}