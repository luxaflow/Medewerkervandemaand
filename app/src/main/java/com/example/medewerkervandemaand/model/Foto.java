package com.example.medewerkervandemaand.model;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Foto {

    private String fotoName;
    private File appDir;
    private File galleryDir;
    private File fotoFile;
    private Uri fotoUri;
    private Bitmap fotoBitmap;

    public Foto(Activity activity){
        this.galleryDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + File.separator + "mvdm");
        this.appDir = activity.getExternalFilesDir("images");

        testPath(galleryDir);
        testPath(appDir);
    }

    public void setFotoName(String name){
        this.fotoName = name;
    }

    public File getGalleryDir(){
        return this.galleryDir;
    }

    public File getAppDir(){
        return this.appDir;
    }

    public void setFotoUri(Uri uri){
        this.fotoUri = uri;
    }

    public Uri getFotoUri(){
        return this.fotoUri;
    }

    public void setFotoFile(File file){
        this.fotoFile = file;
    }

    public void createFotoFile() throws IOException {
        this.fotoFile = File.createTempFile(
                this.fotoName,
                ".jpg",
                this.galleryDir
        );
    }

    public File getFotoFile(){
        return this.fotoFile;
    }

    public void setFotoBitmap(){
       try {
           this.fotoBitmap = BitmapFactory.decodeFile(this.fotoFile.getAbsolutePath());
       } catch (Exception e){
           e.printStackTrace();
       }
    }

    public Bitmap getFotoBitmap(){
        return this.fotoBitmap;
    }

    public void testPath(File dir){
        if(!dir.isDirectory()){
            dir.mkdirs();
        }
    }

    public void fileToUri(){
        if(fotoFile != null)
        this.fotoUri = Uri.fromFile(this.fotoFile);
    }

    public void bitmapToApp(Bitmap bitmap){
        File tempFile = null;
        newFotoName();
        try {
            tempFile = File.createTempFile(this.fotoName, ".jpg", this.appDir);
            FileOutputStream fos = new FileOutputStream(tempFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.fotoFile = tempFile;
    }

    public void newFotoName(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        this.fotoName = "MVDM_" + timeStamp + "_";
    }

    public Uri getContentUri(Activity activity){
        Uri contentUri = null;

        try {
            contentUri = FileProvider.getUriForFile(activity,
                    "com.example.medewerkervandemaand.fileprovider",
                    this.fotoFile);
        } catch (Exception e){
            e.printStackTrace();
        }
        return contentUri;
    }
}
