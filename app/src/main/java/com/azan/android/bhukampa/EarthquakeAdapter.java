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

    private static  final String LOCATION_SEPARATOR = " of ";

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

        // Create new string for location
        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains( LOCATION_SEPARATOR )){
            String [] parts = originalLocation.split( LOCATION_SEPARATOR );
            locationOffset = parts [0] + LOCATION_SEPARATOR;
            primaryLocation = parts [1];
        } else {
            locationOffset = getContext().getString( R.string.near_the );
            primaryLocation = originalLocation;
        }

        // Find the TextView in the list_item.xml layout with the ID of primary location
        TextView primaryLocationView = listItemView.findViewById(R.id.location_primary);
        // Display location
        primaryLocationView.setText(primaryLocation);

        // Find the TextView in the list_item.xml layout with the ID of offset location
        TextView offsetLocationView = listItemView.findViewById(R.id.location_offset);
        // Display location
        offsetLocationView.setText(locationOffset);

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
