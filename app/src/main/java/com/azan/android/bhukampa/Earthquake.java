package com.azan.android.bhukampa;


/**
 * Created by Aminur Rahman on 6/12/17.
 */

public class Earthquake {

    // Magnitude of the earthquake
    private double mMagnitude;

    // Location of the earthquake
    private String mLocation;

    // time of earthquake
    private long mTimeInMilliseconds;

    // Website URL of the earthquake
    private String mUrl;

    /**
     * Constructs a new {@link Earthquake} object.
     *  @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds
     * @param url is the website URL to find the details about earthquake
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url){

        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;

    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds () { return mTimeInMilliseconds; }

    public String getUrl () { return mUrl;}
}
