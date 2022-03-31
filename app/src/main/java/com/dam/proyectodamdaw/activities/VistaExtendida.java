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



    }
}