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

        ImageView imageView = findViewById(R.id.imageExt);
        TextView hora = findViewById(R.id.horaExt);
        TextView fecha = findViewById(R.id.fechaExt);
        TextView grados = findViewById(R.id.gradosExt);
        TextView grMax = findViewById(R.id.grMaxExt);
        TextView grMin = findViewById(R.id.grMinExt);
        TextView grSens = findViewById(R.id.grSensacionExt);
        TextView humedad = findViewById(R.id.numHumedad);

//        imageView.setImageResource(getIntent().getExtras().getString("img"));
        hora.setText(getIntent().getExtras().getString("hora"));
        fecha.setText(getIntent().getExtras().getString("fecha"));
        grados.setText(getIntent().getExtras().getString("grTemp"));
        grMax.setText(getIntent().getExtras().getString("grMax"));
        grMin.setText(getIntent().getExtras().getString("grMin"));
        grSens.setText(getIntent().getExtras().getString("humedad"));
        humedad.setText(getIntent().getExtras().getString("grSens"));

    }
}