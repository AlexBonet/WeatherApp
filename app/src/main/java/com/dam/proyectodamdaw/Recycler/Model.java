package com.dam.proyectodamdaw.Recycler;

import android.view.View;
import android.widget.ImageView;

import com.dam.proyectodamdaw.Parameters;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.base.ImageDownloader;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model model;
    private List<WeatherOne> list;
    String url = Parameters.URL_icon_pre+"03d"+Parameters.URL_icon_pos;

    private Model(){
        list = new ArrayList<>();
//        list.add(new WeatherOne(ImageDownloader.DownloadImage(url,imageView),
//                "Miercoles","20:00","30/03/2022","Soleado",
//                "25º","30º","15º"));

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
