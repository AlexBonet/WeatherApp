package com.dam.proyectodamdaw.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.proyectodamdaw.R;

public class PreferenciasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenciasFragment())
                .commit();
    }
}