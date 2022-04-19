package com.dam.proyectodamdaw.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dam.proyectodamdaw.R;

import java.util.ArrayList;
import java.util.LinkedList;
//TODO cambiar el link de postman

//TODO hacer landscape, vistas y que se guarde al girar
public class ChooseCity extends AppCompatActivity {
    private final int ACT_CIUDAD = 1234;
    private Spinner spinner;
    private Button buttonIr;
    private Button buttonMas;
    private ImageView imageView;
    private ArrayAdapter<Ciudad> adapter;
    private LinkedList<Ciudad> cityList=new LinkedList<>();
    private LinkedList<Ciudad> alterCityList=new LinkedList<>();
    private Ciudad ciudad;

    //Parte de la posicion actual
    private LocationManager managerloc;
    private String proo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_view);

        //Parte de la posicion actual
        managerloc = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setCostAllowed(false);
        criteria.setAltitudeRequired(true);
        criteria.setAccuracy(Criteria.ACCURACY_FINE);

//        proo = managerloc.getBestProvider(criteria,true);
//        @SuppressLint("MissingPermission")
//        Location location = managerloc.getLastKnownLocation(proo);

        spinner=findViewById(R.id.spinner);
        buttonIr=findViewById(R.id.ir);
        buttonMas = findViewById(R.id.añadir);
        imageView=findViewById(R.id.fotodisplay);

        cityList.add(new Ciudad("Lliria", "39.6217623","-0.5955436",R.mipmap.lliria1));
        cityList.add(new Ciudad("Valencia", "39.586127","-0.539420",R.mipmap.vlc1));
        cityList.add(new Ciudad("La Pobla", "39.469607","-0.376453",R.mipmap.lapobla1));

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,cityList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        //TODO poner la posicion actual

//        if (getIntent().getExtras().get("newList") != cityList){
//            alterCityList = (LinkedList<Ciudad>) getIntent().getExtras().get("newList");
//            adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,cityList);
//        }else {
//            adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,alterCityList);
//        }
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad  = cityList.get(i);
                imageView.setImageResource(ciudad.getImage());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Va al recycler
        buttonIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("city", ciudad);
                intent.putExtra("nom", ciudad.getNom());
                intent.putExtra("lat", ciudad.getLat());
                intent.putExtra("lon", ciudad.getLon());
                startActivity(intent);
            }
        });

        //Va a añadir ciudad
        buttonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddCity.class);
                startActivityForResult(intent,ACT_CIUDAD);
            }
        });
    }

    /**
     * de momento no lo utilizamos
     */
    public void addCity(){
        Ciudad c  = (Ciudad) getIntent().getExtras().get("newCity");
        cityList.add(c);
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
                Intent intentPreferenciasActivity = new Intent(getApplicationContext(), PreferenciasActivity.class);
                startActivity(intentPreferenciasActivity);
                return true;
            case (R.id.exit):
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACT_CIUDAD){
            if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "CANCELADO", Toast.LENGTH_SHORT).show();
            }else if (resultCode == RESULT_OK){
                String cNom = data.getExtras().getString("cNom");
                String cLat = data.getExtras().getString("cLat");
                String cLon = data.getExtras().getString("cLon");
                Ciudad c = new Ciudad(cNom,cLat,cLon,R.mipmap.ciudad1);
                cityList.add(c);
                adapter.notifyDataSetChanged();
            }
        }
    }
}