package com.example.medewerkervandemaand.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.medewerkervandemaand.R;
import com.example.medewerkervandemaand.model.Camera;
import com.example.medewerkervandemaand.model.Foto;
import com.example.medewerkervandemaand.model.GalleryHandler;
import com.example.medewerkervandemaand.model.PermissionRequester;

public class MainActivity extends AppCompatActivity {


    private Button takeFotoButton;
    private Button chooseFotoButton;
    private Foto foto;

    private Boolean cameraPermission = false;
    private PermissionRequester permissionRequester;
    private GalleryHandler galleryHandler = new GalleryHandler();

    public static final int TAKE_FOTO = 1;
    public static final int PICK_FOTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.setButtons();
        requestCameraPermission();
    }

    public void requestCameraPermission(){
        this.permissionRequester = new PermissionRequester();
        this.cameraPermission = this.permissionRequester.requestCameraPermission(MainActivity.this);
    }


    public void setButtons() {
        this.takeFotoButton = findViewById(R.id.takePicture);
        this.chooseFotoButton = findViewById(R.id.selectPicture);

        setTakeFotoButton();
        setSelectPictureListener();
    }

    public void setTakeFotoButton() {
        this.takeFotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cameraPermission) {
                    foto = new Foto(MainActivity.this);
                    Camera camera = new Camera();
                    camera.takeFoto(MainActivity.this);
                    foto = camera.getFoto();
                }
            }
        });
    }

    public void setSelectPictureListener() {
        chooseFotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryHandler.chooseFoto(MainActivity.this, PICK_FOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent fotoReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, fotoReturnedIntent);

        if (resultCode == RESULT_OK) {
            if (requestCode == TAKE_FOTO) {
                if (foto != null) {
                    foto.fileToUri();
                    Intent editImageActivityIntent = new Intent(MainActivity.this, EditActivity.class);
                    editImageActivityIntent.putExtra("IMAGE_URI", foto.getFotoUri().toString());
                    startActivity(editImageActivityIntent);
                }
            } else if (requestCode == PICK_FOTO) {
                foto.setFotoUri(fotoReturnedIntent.getData());
                if (foto.getFotoUri() != null) {
                    Intent editImageActivityIntent = new Intent(MainActivity.this, EditActivity.class);
                    editImageActivityIntent.putExtra("IMAGE_URI", foto.getFotoUri().toString());
                    startActivity(editImageActivityIntent);
                }
            }
        }
    }
}
