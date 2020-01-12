package com.jc_designs.mytpi;

import android.content.Context;
import android.widget.Toast;

import com.jc_designs.mytpi.Appliances.MEWP;

/**
 * Created by Joshua on 24/06/2016.
 */
public class globalVariables {

    public static String ID;
    public static String OUTCOME_STRING;
    public static String PDF_NAME;

    public static String FLEET_NUMBER;
    public static String SERIAL_NUMBER;
    public static String CLIENT;
    public static String DATE;
    public static String NAME;
    public static String NEXT_INSPECTION;
    public static String OUTCOME;
    public static String START_TIME;
    public static String END_TIME;
    public static String DURATION;
    public static String TIMESHEET;

    public static String PERMISSIONS;
    public static int ACCESS;


    public static String FIREBASE_URL = "https://mytpi-97ad0.firebaseio.com";


    //CERT NUMBER VARIABLES
    public static String PASSWORD;
    public static String EMAIL;
    public static String UID;

    public static String FULL_NAME;

    public static int PERMISSION;

    public static MEWP SELECTED_MEWP = new MEWP();


    //FUNCTIONS

    public static void makeToast(Context view, String message){

        Toast.makeText(view, message, Toast.LENGTH_SHORT).show();
    }







}
