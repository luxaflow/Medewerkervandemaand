package com.example.medewerkervandemaand.model;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import java.io.IOException;

public class Camera {

    private GalleryHandler galleryHandler = new GalleryHandler();
    private Foto foto;

    private static final int REQUEST_TAKE_PHOTO = 1;

    public void takeFoto(Activity activity){
        Intent takeFotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.foto = new Foto(activity);
        this.foto.newFotoName();
        if (takeFotoIntent.resolveActivity(activity.getPackageManager()) != null) {

            try {
                this.foto.createFotoFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (this.foto.getFotoFile() != null) {
                this.foto.setFotoUri(FileProvider.getUriForFile(activity,
                        "com.example.medewerkervandemaand.fileprovider",
                        this.foto.getFotoFile()));

                takeFotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, foto.getFotoUri());
                activity.startActivityForResult(takeFotoIntent, REQUEST_TAKE_PHOTO);

                this.galleryHandler.galleryAddPic(activity, foto.getFotoFile());
            }
        }
    }

    public Foto getFoto(){
        return this.foto;
    }
}
