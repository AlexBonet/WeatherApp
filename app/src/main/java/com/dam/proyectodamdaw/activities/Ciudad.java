package com.dam.proyectodamdaw.activities;

import android.widget.ImageView;

import java.io.Serializable;

public class Ciudad implements Serializable {
    private String nom;
    private String lat;
    private String lon;
    private int imageView;
    private String url;

    public Ciudad(String nom, String lat, String lon, int imageView) {
        this.nom = nom;
        this.lat = lat;
        this.lon = lon;
        this.imageView = imageView;
    }

    public Ciudad(String nom, String lat, String lon) {
        this.nom = nom;
        this.lat = lat;
        this.lon = lon;
    }

    public Ciudad(String nom, String lat, String lon, String url) {
        this.nom = nom;
        this.lat = lat;
        this.lon = lon;
        this.url = url;
    }

    public String getNom() {
        return nom;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public int getImage() {
        return imageView;
    }

    public String getUrl() {
        return url;
    }

    public int getImageView() {
        return imageView;
    }

    @Override
    public String toString() {
        return  nom ;
    }
}
