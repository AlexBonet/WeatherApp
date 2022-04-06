package com.dam.proyectodamdaw.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.proyectodamdaw.Parameters;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.base.ImageDownloader;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VistaExtendida extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extended_view);
        List list = (List) getIntent().getExtras().getSerializable("root");


        ImageView imageView = findViewById(R.id.imageExt);
        TextView hora = findViewById(R.id.horaExt);
        TextView fecha = findViewById(R.id.fechaExt);
        TextView grados = findViewById(R.id.gradosExt);
        TextView grMax = findViewById(R.id.grMaxExt);
        TextView grMin = findViewById(R.id.grMinExt);
        TextView grSens = findViewById(R.id.grSensacionExt);
        TextView humedad = findViewById(R.id.numHumedad);

        String codImagen = list.weather.get(0).icon;
        ImageDownloader.DownloadImage(Parameters.URL_icon_pre + codImagen + Parameters.URL_icon_pos, imageView);


        Date date = new Date((long)list.dt*1000);
        hora.setText(new SimpleDateFormat("HH:mm").format(date));
        fecha.setText(new SimpleDateFormat("dd/MM/YYYY").format(date));
        grMin.setText(String.valueOf(list.main.temp_min));
        grMax.setText(String.valueOf(list.main.temp_max));
        grados.setText(String.valueOf(list.main.temp));
        grSens.setText(String.valueOf(list.main.feels_like));
        humedad.setText(String.valueOf(list.main.humidity));

    }
}