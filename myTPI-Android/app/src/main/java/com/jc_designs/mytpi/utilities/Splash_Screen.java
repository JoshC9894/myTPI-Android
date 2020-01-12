package com.jc_designs.mytpi.utilities;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jc_designs.mytpi.Appliances.Machine_Database;
import com.jc_designs.mytpi.Authorisation.Login;
import com.jc_designs.mytpi.Home;
import com.jc_designs.mytpi.R;
import com.jc_designs.mytpi.globalVariables;

public class Splash_Screen extends Permissons_Main {

    private static int SPLASH_SHOW_TIME;

    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authListner;
    private static final String TAG = "MyActivity";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        new BackgroundSplashTask().execute();

        auth = FirebaseAuth.getInstance();
        authListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = auth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

                    globalVariables.FULL_NAME = auth.getCurrentUser().getDisplayName();
                    globalVariables.PERMISSION = 2;
                    globalVariables.UID = auth.getCurrentUser().getUid();
                    auth.removeAuthStateListener(authListner);

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    globalVariables.PERMISSION = 1;
                }
            }
        };

        Machine_Database myDB = new Machine_Database(this);
        //this.deleteDatabase(myDB.DATABASE_NAME);

    }

    @Override
    protected String[] getRequiredPermissons() {
        return new  String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET
        };
    }

    @Override
    protected void onAllRequiredPermissionsGranted() {
        StringBuilder sb = new StringBuilder();

        for (String permission : getRequiredPermissons()){
            sb.append(permission).append("\n");
        }



    }

    private class BackgroundSplashTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
        while (globalVariables.ACCESS != 1){
            if (globalVariables.ACCESS == 0){
                SPLASH_SHOW_TIME = 800;
            } else if (globalVariables.ACCESS == 1) {
                SPLASH_SHOW_TIME = 800;
            }}

            try {
                Thread.sleep(SPLASH_SHOW_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);


            if (globalVariables.PERMISSION == 1){

                Intent intent = new Intent(Splash_Screen.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            } else if (globalVariables.PERMISSION == 2){

                Intent intent = new Intent(Splash_Screen.this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }



        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListner);
    }

    @Override
    protected void onResume() {
        super.onResume();
        auth.addAuthStateListener(authListner);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListner != null) {
            auth.removeAuthStateListener(authListner);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (authListner != null) {
            auth.removeAuthStateListener(authListner);
        }
    }
}

