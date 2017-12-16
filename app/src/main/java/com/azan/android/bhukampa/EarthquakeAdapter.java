package com.azan.android.bhukampa;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
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
        TextView magnitudeView =  listItemView.findViewById(R.id.magnitude);
        //Format magnitude into 1 decimal place
        String formattedMagnitude = formatMagnitude (currentEarthquake.getMagnitude());
        // Display magnitude
        magnitudeView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is GradientDrawable
        GradientDrawable magnitudeCircle =(GradientDrawable) magnitudeView.getBackground();
        // Get the appropriate background color based on current earthquake magnitude
        int magnitudeColor = getMagnitudeColor (currentEarthquake.getMagnitude());
        // set the color on the magnitude circle
        magnitudeCircle.setColor( magnitudeColor );



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

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor( magnitude );
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor( getContext(),magnitudeColorResourceId );
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat( "0.0" );
        return magnitudeFormat.format( magnitude );
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
