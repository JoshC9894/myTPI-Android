package com.jc_designs.mytpi.utilities;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.jc_designs.mytpi.globalVariables;

import java.util.ArrayList;

/**
 * Created by Joshua on 03/08/2016.
 */
public class Permissons_Main extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!hasAllRequiredPermissions()){
            globalVariables.ACCESS = 0;
            requestAllRequiredPermissions();
        } else {
            globalVariables.ACCESS = 1;
        }
    }

    private static final int REQUEST_ALL_MISSING_PERMISSIONS = 1;


    protected String[] getRequiredPermissons() {
        return new String[0];
    }

    protected void onAllRequiredPermissionsGranted() {

    }

    private boolean hasAllRequiredPermissions() {
        for (String permission : getRequiredPermissons()) {
            if (!Permission_Check.hasPermission(getApplicationContext(), permission)) {
                return false;
            }
        }
        return true;
    }

    private void requestAllRequiredPermissions(){
        ArrayList<String> notGrantedPermissions = new ArrayList<>();

        for (String permission : getRequiredPermissons()){
            if (!Permission_Check.hasPermission(getApplicationContext(), permission)){
                notGrantedPermissions.add(permission);
            }
        }

        if (notGrantedPermissions.size() > 0){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(notGrantedPermissions.toArray(new String[notGrantedPermissions.size()]), REQUEST_ALL_MISSING_PERMISSIONS);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case REQUEST_ALL_MISSING_PERMISSIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    onAllRequiredPermissionsGranted();
                } else {
                    globalVariables.makeToast(getApplicationContext(), "Please allow permissions");
                }
                return;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
