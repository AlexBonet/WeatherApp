package com.dam.proyectodamdaw.Recycler;

import android.widget.ImageView;

public class Ciudad {
    private String nom;
    private long lat;
    private long lon;
    private ImageView imageView;

    public Ciudad(String nom, long lat, long lon, ImageView imageView) {
        this.nom = nom;
        this.lat = lat;
        this.lon = lon;
        this.imageView = imageView;
    }

    public String getNom() {
        return nom;
    }

    public long getLat() {
        return lat;
    }

    public long getLon() {
        return lon;
    }

    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public String toString() {
        return  nom ;
    }
}
