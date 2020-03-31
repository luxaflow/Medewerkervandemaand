package com.example.medewerkervandemaand.model;

import android.app.Activity;
import android.graphics.Color;
import android.text.Layout;

import com.xiaopo.flying.sticker.StickerView;
import com.xiaopo.flying.sticker.TextSticker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MonthTextSticker {

    public void addMonthTextSticker(Activity activity, StickerView stickerView){
        TextSticker sticker = new TextSticker(activity);
        sticker.setTextColor(Color.WHITE);
        sticker.setText("Novi medewerker van " + getCurrentMonthName());
        sticker.setTextAlign(Layout.Alignment.ALIGN_CENTER);
        sticker.resizeText();
        stickerView.addSticker(sticker);

    }

    public String getCurrentMonthName(){

        DateFormat dateFormat = new SimpleDateFormat("MM");

        Date date = new Date();

        switch (dateFormat.format(date)) {
            case "01":
                return "Januari";
            case "02":
                return "Februari";
            case "03":
                return "Maart";
            case "04":
                return "April";
            case "05":
                return "Mei";
            case "06":
                return "Juni";
            case "07":
                return "Juli";
            case "08":
                return "Augustus";
            case "09":
                return "September";
            case "10":
                return "Oktober";
            case "11":
                return "November";
            case "12":
                return "December";
            default:
                return "No Month";
        }


    }
}
