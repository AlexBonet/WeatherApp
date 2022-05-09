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
import com.dam.proyectodamdaw.api.API;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.api.Result;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChooseCity extends BaseActivity implements CallInterface {
    private final int ACT_CIUDAD = 1234;
    private Spinner spinner;
    private Button buttonIr, buttonMas;
    private ImageView imageView;
    private ArrayAdapter<Ciudad> adapter;
    private List<Ciudad> cityList= new LinkedList<>();
    private Ciudad ciudad;

    // Part de acceso a bd
    private Result result;

    //Parte de la posicion actual
    private LocationManager managerloc;
    private String proo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_view);

        spinner=findViewById(R.id.spinner);
        buttonIr=findViewById(R.id.ir);
        buttonMas = findViewById(R.id.añadir);
        imageView=findViewById(R.id.fotodisplay);

        executeCall(ChooseCity.this);

        cityList.add(new Ciudad("Default",  "39.6217623","-0.5955436",R.mipmap.ciudad1));

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

    @Override // Coses de menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // Coses de preferencias
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
                Ciudad c = new Ciudad(cNom,cLat,cLon);
                cityList.add(c);
                adapter.notifyDataSetChanged();
            }
        }
    }
    
    @Override // Guardar estado -> girar pantalla
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putSerializable("adaptador", (Serializable) adapter);
        outState.putSerializable("lista", (Serializable) cityList);
    }

    @Override // Restaurar estado -> girar pantalla
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        adapter = (ArrayAdapter<Ciudad>) savedInstanceState.getSerializable("adaptador");
        cityList = (List<Ciudad>) savedInstanceState.getSerializable("lista");
    }

    @Override
    public void doInBackground() {
        cityList.addAll(Connector.getConector().getAsListDB(Ciudad.class, API.Routes.GET_ALL));

    }

    @Override
    public void doInUI() {
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,cityList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }
}