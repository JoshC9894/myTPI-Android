package com.jc_designs.mytpi.utilities;

import android.Manifest;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Window;
import android.view.WindowManager;

import com.jc_designs.mytpi.R;

/**
 * Created by Joshua on 03/08/2016.
 */
public class Load_Screen extends Permissons_Main {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_splash_screen);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



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



}
