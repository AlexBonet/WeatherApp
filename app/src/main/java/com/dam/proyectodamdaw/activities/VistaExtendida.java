package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        TextView grados = findViewById(R.id.gradosExt);
        TextView grMax = findViewById(R.id.grMaxExt);
        TextView grMin = findViewById(R.id.grMinExt);
        TextView grSens = findViewById(R.id.grSensacionExt);
        TextView humedad = findViewById(R.id.numHumedad);
        TextView viento = findViewById(R.id.numViento);
        TextView descripcion = findViewById(R.id.dt_txt);

        String codImagen = list.weather.get(0).icon;
        ImageDownloader.DownloadImage(Parameters.URL_icon_pre + codImagen + Parameters.URL_icon_pos, imageView);

        grMin.setText(String.valueOf(list.main.temp_min));
        grMax.setText(String.valueOf(list.main.temp_max));
        grados.setText(String.valueOf(list.main.temp));
        grSens.setText(String.valueOf(list.main.feels_like));
        humedad.setText(String.valueOf(list.main.humidity));
        viento.setText(String.valueOf(list.wind.speed));
        descripcion.setText(list.dt_txt);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.confi):
                Intent intentPreferenciasActivity = new Intent(this, PreferenciasActivity.class);
                startActivity(intentPreferenciasActivity);
                return true;
            case (R.id.exit):
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}