package com.example.medewerkervandemaand.model;

import android.app.Activity;

import java.io.File;
import java.util.ArrayList;

public class Fotos {

    private ArrayList<Foto> fotos;

    public Fotos(Activity activity){
        fotos = new ArrayList<Foto>();

        Foto foto = new Foto(activity);
        File directoy = foto.getAppDir();
        File[] files = directoy.listFiles();
        for(int i = 0; i < files.length; i++){
            Foto newFoto = new Foto(activity);
            newFoto.setFotoFile(files[i]);
            newFoto.setFotoBitmap();
            newFoto.setFotoName(files[i].getName());
            this.fotos.add(newFoto);
        }
    }

    public ArrayList<Foto> getFotos(){
        return fotos;
    }
}
