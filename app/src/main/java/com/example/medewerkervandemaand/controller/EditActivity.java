package com.example.medewerkervandemaand.controller;


import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.medewerkervandemaand.R;

import com.example.medewerkervandemaand.model.IntentHandler;
import com.example.medewerkervandemaand.model.MonthTextSticker;
import com.example.medewerkervandemaand.model.Stickers;
import com.example.medewerkervandemaand.model.Foto;

import com.xiaopo.flying.sticker.StickerView;

public class EditActivity extends AppCompatActivity {

    private Button saveButton;
    private Button textButton;
    private ImageView imageEditView;
    private Bitmap imageBitmap = null;

    private Stickers stickers;
    private Foto foto;
    private IntentHandler intentHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        intentHandler = new IntentHandler(EditActivity.this);

        imageBitmap = intentHandler.bitmapFromIntentUri();

        imageEditView = findViewById(R.id.imageEditView);
        imageEditView.setImageBitmap(imageBitmap);

        stickers = new Stickers();
        stickers.setEditActivityStickers(EditActivity.this);
        setCnClickSaveListener();
        setOnClickTextListener();
    }

    public void setCnClickSaveListener(){
        saveButton = findViewById(R.id.saveImage);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    foto = new Foto(EditActivity.this);
                    foto.newFotoName();
                    StickerView stickerView = findViewById(R.id.stickerView);
                    foto.bitmapToApp(stickerView.createBitmap());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(foto.getFotoFile().isFile()){
                    Intent shareActivityIntent = new Intent(EditActivity.this, ShareActivity.class);
                    shareActivityIntent.putExtra("IMAGE_FILE", foto.getFotoFile().getAbsolutePath());
                    startActivity(shareActivityIntent);
                }
            }
        });
    }

    public void setOnClickTextListener(){

        textButton = findViewById(R.id.Text);

        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonthTextSticker monthText = new MonthTextSticker();
                StickerView stickerView = findViewById(R.id.stickerView);
                monthText.addMonthTextSticker(EditActivity.this, stickerView);
            }
        });
    }
}

