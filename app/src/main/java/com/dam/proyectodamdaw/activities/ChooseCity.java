package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.proyectodamdaw.R;

public class ChooseCity extends AppCompatActivity {

    private Spinner spinner;
    private Button buttonIr;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_view);

        spinner=findViewById(R.id.spinner);
        buttonIr=findViewById(R.id.ir);
        imageView=findViewById(R.id.fotodisplay);

        Ciudad[] ciudades= {

                new Ciudad("Lliria", "39.6217623","-0.5955436",R.mipmap.lliria1),
                new Ciudad("Valencia", "39.586127","-0.539420",R.mipmap.vlc1),
                new Ciudad("La Pobla", "39.469607","-0.376453",R.mipmap.lapobla1)
        };


        ArrayAdapter<Ciudad> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,ciudades);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(ciudades[i].getImage());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String nom = spinner.getSelectedItem().toString();
                intent.putExtra("city", nom);
//                intent.putExtra("lat", ciudades[i].getLat());
//                intent.putExtra("lon", ciudades[i].getLon());
                startActivity(intent);
            }
        });
    }
}