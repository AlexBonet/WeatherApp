package com.dam.proyectodamdaw.Recycler;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model model;
    private List<WeatherOne> list;

    private Model(){
        list = new ArrayList<>();
        list.add(new WeatherOne());
    }

    public static Model getInstance(){
        if(model==null)
            model = new Model();

        return model;
    }

    public List<WeatherOne> getList() {
        return list;
    }
}
