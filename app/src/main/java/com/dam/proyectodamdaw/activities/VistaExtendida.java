package com.dam.proyectodamdaw.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.proyectodamdaw.R;

public class VistaExtendida extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extended_view);
        List list = (List) getIntent().getExtras().getSerializable("root");
        int posi = getIntent().getExtras().getInt("posicion");

        ImageView imageView = findViewById(R.id.imageExt);
        TextView hora = findViewById(R.id.horaExt);
        TextView fecha = findViewById(R.id.fechaExt);
        TextView grados = findViewById(R.id.gradosExt);
        TextView grMax = findViewById(R.id.grMaxExt);
        TextView grMin = findViewById(R.id.grMinExt);
        TextView grSens = findViewById(R.id.grSensacionExt);
        TextView humedad = findViewById(R.id.numHumedad);

//        imageView.setImageResource(getIntent().getExtras().getString("img"));

        fecha.setText(String.valueOf(list.dt));
        hora.setText(String.valueOf(list.weather.get(posi).main));
        grMin.setText(String.valueOf(list.main.temp_min));
        grMax.setText(String.valueOf(list.main.temp_max));
        grados.setText(String.valueOf(list.main.temp));
        grSens.setText(String.valueOf(list.main.feels_like));
        humedad.setText(String.valueOf(list.main.humidity));

    }
}