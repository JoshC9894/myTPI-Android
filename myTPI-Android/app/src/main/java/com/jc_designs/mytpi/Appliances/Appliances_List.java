package com.jc_designs.mytpi.Appliances;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jc_designs.mytpi.R;
import com.jc_designs.mytpi.globalVariables;
import com.jc_designs.mytpi.utilities.HomeCustomAdapter;

/**
 * Created by Joshua on 19/01/2017.
 */
public class Appliances_List extends Fragment {

    View myView;

    Machine_Database myDB;
    public static ListView myList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.appliances_layout, container, false);
        return myView;
    }



    @Override
    public void onStart() {
        super.onStart();

        myList = (ListView) myView.findViewById(R.id.applianceList);

        myDB = new Machine_Database(getActivity());

        populateListView();

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                final TextView idField = (TextView)view.findViewById(R.id.idListLabel);
                final TextView startTime = (TextView)view.findViewById(R.id.timeField);
                globalVariables.ID = idField.getText().toString();
                globalVariables.START_TIME = startTime.getText().toString();
                Intent nextActivity = new Intent(getActivity(), Machine_Checklist.class);
                startActivity(nextActivity);

                System.out.println(globalVariables.ID);
            }
        });

        myList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final TextView fleetField = (TextView)view.findViewById(R.id.machineIDList);
                final TextView idField = (TextView)view.findViewById(R.id.idListLabel);

                final AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
                b.setIcon(android.R.drawable.ic_dialog_alert);
                b.setTitle("Delete Inspection:  " + fleetField.getText().toString());
                b.setMessage("Are you sure?");

                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {

                        assert idField != null;
                        Integer deletedRow = myDB.deleteData(idField.getText().toString());
                        if (deletedRow > 0){
                            Toast.makeText(getActivity(), "Data Deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Data Failed to Delete", Toast.LENGTH_SHORT).show();
                        }
                        populateListView();

                    }
                });

                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(getActivity(), "Delete Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                b.show();


                return true;
            }
        });
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();


    }


    void populateListView(){
        Cursor cursor = myDB.getAllData();
        String[] fromFieldNames = new String[]{
                Machine_Database.COLUMN_ID,
                Machine_Database.COLUMN_FLEET,
                Machine_Database.COLUMN_SERIAL,
                Machine_Database.COLUMN_CLIENT,
                Machine_Database.COLUMN_DATE,
                Machine_Database.COLUMN_START_TIME,
                Machine_Database.COLUMN_CERT_NUMBER,
                Machine_Database.COLUMN_OUTCOME
        };
/**
        int[] toViewIDs = new int[] {
                R.id.idListLabel,
                R.id.modelMEWPList,
                R.id.whMEWPList,
                R.id.rMEWPList,
                R.id.phMEWPList,
                R.id.timeField,
                R.id.certListLabel,
                R.id.outcomeListLabel
        };

        myCursorAdapter = new SimpleCursorAdapter(getActivity(),R.layout.long_list_view, cursor, fromFieldNames, toViewIDs, 0);



        myList.setAdapter(myCursorAdapter);*/

        HomeCustomAdapter hca = new HomeCustomAdapter(getActivity(), cursor);
        myList.setAdapter(hca);

        int items;
        items = myList.getCount();

        if (items == 0){
            myList.setBackgroundResource(R.drawable.appliance_bg);
        } else {
            myList.setBackgroundResource(0);
        }

    }
}
