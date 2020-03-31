package com.example.medewerkervandemaand.model;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionRequester {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE= 0;

    public boolean requestCameraPermission(Activity activity){

        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        }
        System.out.println(MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
        return true;
    }

}
