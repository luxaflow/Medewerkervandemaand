package com.example.medewerkervandemaand.model;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;


import com.example.medewerkervandemaand.R;
import com.example.medewerkervandemaand.controller.EditActivity;
import com.xiaopo.flying.sticker.BitmapStickerIcon;
import com.xiaopo.flying.sticker.StickerView;

public class Stickers {

    StickerView stickerView;

    ImageView tophatView;
    ImageView moustacheView;
    ImageView redNoseView;
    ImageView redLipsView;
    ImageView partyHatView;
    ImageView monicleView;

    public void setEditActivityStickers(final Activity activity){

        stickerView = activity.findViewById(R.id.stickerView);

        tophatView = activity.findViewById(R.id.top_hat);
        redLipsView = activity.findViewById(R.id.redlips);
        moustacheView = activity.findViewById(R.id.moustache);
        redNoseView = activity.findViewById(R.id.red_nose);
        partyHatView = activity.findViewById(R.id.party_hat);
        monicleView = activity.findViewById(R.id.monicle);

        tophatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon tophat = new BitmapStickerIcon(ContextCompat.getDrawable(activity ,
                        R.mipmap.top_hat), BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(tophat);
            }
        });

        redLipsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon redlips = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.red_lips), BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(redlips);
            }
        });

        moustacheView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon moustache = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.moustache), BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(moustache);
            }
        });

        redNoseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon rednose = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.red_nose), BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(rednose);
            }
        });

        partyHatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon partyHat = new BitmapStickerIcon(ContextCompat.getDrawable(activity,
                        R.mipmap.party_hat), BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(partyHat);
            }
        });

        monicleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapStickerIcon monicle= new BitmapStickerIcon(ContextCompat.getDrawable(activity ,
                        R.mipmap.monicle), BitmapStickerIcon.LEFT_BOTTOM);
                stickerView.addSticker(monicle);
            }
        });
    }
}
