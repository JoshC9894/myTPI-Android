package com.jc_designs.mytpi.utilities;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jc_designs.mytpi.R;

/**
 * Created by Joshua on 24/01/2017.
 */
public class HomeCustomAdapter extends CursorAdapter {

    public HomeCustomAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.long_list_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //Labels
        TextView machineLabel = (TextView)view.findViewById(R.id.machineIDList);
        TextView idLabel = (TextView)view.findViewById(R.id.idListLabel);
        TextView clientLabel = (TextView)view.findViewById(R.id.clientList);
        TextView timeLabel = (TextView)view.findViewById(R.id.timeField);
        TextView dateLabel = (TextView)view.findViewById(R.id.dateList);
        ImageView outcomeImage = (ImageView)view.findViewById(R.id.outcomeImageList);

        //DB Values
        String outcome = cursor.getString(cursor.getColumnIndexOrThrow("outcome"));
        String id = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String fleet = cursor.getString(cursor.getColumnIndexOrThrow("fleet"));
        String serial = cursor.getString(cursor.getColumnIndexOrThrow("serial"));
        String client = cursor.getString(cursor.getColumnIndexOrThrow("client"));
        String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));


        if (outcome.equals("Satisfactory")) {
            outcomeImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.pass_icon));
        } else if (outcome.equals("Unsatisfactory")) {
            outcomeImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.fail_icon));
        } else {
            outcomeImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.incomplete_icon));
        }

        if (fleet.equals("") || fleet.equals(" ") || fleet.equals("N/A") || fleet.equals("Not Available") || fleet.equals("Not Applicable")) {
            machineLabel.setText(serial);
        } else {
            machineLabel.setText(fleet);
        }

        //Populate
        idLabel.setText(id);
        clientLabel.setText(client);
        dateLabel.setText(date);
    }
}
