package com.example.medewerkervandemaand.model;

import android.app.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;

public class IntentHandler {

    private Activity currentActivity;

    public IntentHandler(Activity activity){

        setCurrentActivity(activity);
    }

    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }

    public Uri uriFromIntent(){
        return Uri.parse(currentActivity.getIntent().getStringExtra("IMAGE_URI"));
    }


    public Bitmap bitmapFromIntentUri(){

        Bitmap imageBitmap = null;

        Uri imageUri = Uri.parse(currentActivity.getIntent().getStringExtra("IMAGE_URI"));

        try{
            InputStream inputStream = currentActivity.getContentResolver().openInputStream(imageUri);
            imageBitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageBitmap;
    }
}
