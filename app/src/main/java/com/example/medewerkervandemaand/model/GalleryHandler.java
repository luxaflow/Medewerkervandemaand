package com.example.medewerkervandemaand.model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

public class GalleryHandler {

    public void galleryAddPic(Activity activity, File file) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(file);
        mediaScanIntent.setData(contentUri);
        activity.sendBroadcast(mediaScanIntent);
    }

    public void chooseFoto(Activity activity, Integer num){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), num);
    }
}
