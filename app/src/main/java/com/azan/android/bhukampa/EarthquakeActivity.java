package com.azan.android.bhukampa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.earthquake_activity );

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake(  "4.6","San Francisco", "13 Dec 2017"));
        earthquakes.add(new Earthquake(  "3.9","Sydney", "10 jan 1999"));
        earthquakes.add(new Earthquake(  "1.2","Dhaka", "24 Apr 2017"));
        earthquakes.add(new Earthquake(  "4.6","San Francisco", "13 Dec 2017"));
        earthquakes.add(new Earthquake(  "4.6","San Francisco", "13 Dec 2017"));
        earthquakes.add(new Earthquake(  "4.6","San Francisco", "13 Dec 2017"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter( this, earthquakes );
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}
