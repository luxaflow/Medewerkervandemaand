package com.example.medewerkervandemaand.controller;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.medewerkervandemaand.R;
import com.example.medewerkervandemaand.model.Foto;
import com.example.medewerkervandemaand.model.Fotos;

import java.io.File;
import java.util.ArrayList;

public class ShareActivity extends AppCompatActivity {

    private ArrayList<Foto> fotos;
    private LinearLayout linearLayout;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        fotos = new Fotos(ShareActivity.this).getFotos();
        shareButton = findViewById(R.id.shareButton);
        linearLayout = findViewById(R.id.LinearImages);
        shareButton.setEnabled(false);

        for(final Foto foto: fotos){
            ImageView imageView = new ImageView(ShareActivity.this);
            imageView.setImageBitmap(foto.getFotoBitmap());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shareButton.setEnabled(true);
                    setShareButton(foto.getContentUri(ShareActivity.this));
                }
            });
            linearLayout.addView(imageView);
        }
    }

    public void setShareButton(final Uri fotoUri){
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);

                sharingIntent.setType("image/jpg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, fotoUri);
                startActivity(Intent.createChooser(sharingIntent, "Share image using"));
            }
        });
    }
}
