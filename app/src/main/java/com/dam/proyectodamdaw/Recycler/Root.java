package com.dam.proyectodamdaw.Recycler;

import java.io.Serializable;
import java.util.ArrayList;
class Main implements Serializable {
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int sea_level;
    public int grnd_level;
    public int humidity;
    public double temp_kf;
}

class Weather implements Serializable{
    public int id;
    public String main;
    public String description;
    public String icon;
}

class Clouds implements Serializable{
    public int all;
}

class Wind implements Serializable{
    public double speed;
    public int deg;
    public double gust;
}

class Rain implements Serializable{
    public double _3h;
}

class Sys implements Serializable{
    public String pod;
}

class List implements Serializable{
    public int dt;
    public Main main;
    public ArrayList<Weather> weather;
    public Clouds clouds;
    public Wind wind;
    public int visibility;
    public double pop;
    public Rain rain;
    public Sys sys;
    public String dt_txt;
}

class Coord implements Serializable{
    public double lat;
    public double lon;
}

class City implements Serializable{
    public int id;
    public String name;
    public Coord coord;
    public String country;
    public int population;
    public int timezone;
    public int sunrise;
    public int sunset;
}

public class Root implements Serializable{
    public String cod;
    public int message;
    public int cnt;
    public ArrayList<List> list;
    public City city;
}

