package com.azan.android.bhukampa;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Raeeda-Azan on 6/12/17.
 */

public class EarthquakeAdapter extends ArrayAdapter <Earthquake> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, ArrayList <Earthquake> earthquakes){
        super(context, 0, earthquakes);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link EarthquakeFlavor} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitudeTextView =  listItemView.findViewById(R.id.magnitude);
        // Display magnitude
        magnitudeTextView.setText(currentEarthquake.getMagnitude());

        // Find the TextView in the list_item.xml layout with the ID location
        TextView locationTextView = listItemView.findViewById(R.id.location);
        // Display location
        locationTextView.setText(currentEarthquake.getLocation());

        //Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date( currentEarthquake.getTimeInMilliseconds() );

        // Find TextView for date
        TextView dateView = listItemView.findViewById( R.id.date );
        //Format date string (i.e. Mar 3, 1983)
        String formattedDate = formatDate(dateObject);
        // display date
        dateView.setText( formattedDate );


        // Find the TextView in the list_item.xml layout with the ID time
        TextView timeView = listItemView.findViewById(R.id.time);
        // Format the time string (e.g. 4:00 PM)
        String formattedTime = formatTime(dateObject);
        // set this text on the number TextView
        timeView.setText(formattedTime);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "LLL dd, yyyy" );
        return dateFormat.format( dateObject );
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat( "h:mm a" );
        return timeFormat.format( dateObject );
    }

}
