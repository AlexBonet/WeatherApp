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

    private ImageView imageView;
    private TextView grados, grMax, grMin, grSens, humedad,viento, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extended_view);
        List list = (List) getIntent().getExtras().getSerializable("root");


        imageView = findViewById(R.id.imageExt);
         grados = findViewById(R.id.gradosExt);
         grMax = findViewById(R.id.grMaxExt);
         grMin = findViewById(R.id.grMinExt);
         grSens = findViewById(R.id.grSensacionExt);
         humedad = findViewById(R.id.numHumedad);
         viento = findViewById(R.id.numViento);
         descripcion = findViewById(R.id.dt_txt);

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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("image",imageView.getImageAlpha());
        outState.putString("grados",grados.getText().toString());
        outState.putString("grMax",grMax.getText().toString());
        outState.putString("grMin",grMin.getText().toString());
        outState.putString("grSens",grSens.getText().toString());
        outState.putString("humedad",humedad.getText().toString());
        outState.putString("viento",viento.getText().toString());
        outState.putString("descripcion",descripcion.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        imageView.setImageResource(R.drawable.ic_round_cloud_off_24);
        grados.setText(savedInstanceState.getString("grados",""));
        grMax.setText(savedInstanceState.getString("grMax",""));
        grMin.setText(savedInstanceState.getString("grMin",""));
        grSens.setText(savedInstanceState.getString("grSens",""));
        humedad.setText(savedInstanceState.getString("humedad",""));
        viento.setText(savedInstanceState.getString("viento",""));
        descripcion.setText(savedInstanceState.getString("descripcion","informacion no recivida"));
    }
}