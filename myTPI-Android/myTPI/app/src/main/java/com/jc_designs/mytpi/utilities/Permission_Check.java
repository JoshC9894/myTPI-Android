package com.jc_designs.mytpi.utilities;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by Joshua on 02/08/2016.
 */
public class Permission_Check {

    public static boolean hasPermission(Context context, String permission){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            return  context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }
}
