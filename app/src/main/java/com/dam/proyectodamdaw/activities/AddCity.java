package com.dam.proyectodamdaw.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.api.API;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.api.Result;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;

import java.util.LinkedList;

public class AddCity extends BaseActivity implements CallInterface {

    private Button add;
    private Button cancel;
    private EditText nom;
    private EditText lat;
    private EditText lon;

    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        add = findViewById(R.id.addButton);
        cancel = findViewById(R.id.cancelButton);
        nom = findViewById(R.id.nameEditTxt);
        lat = findViewById(R.id.latEditTxt);
        lon = findViewById(R.id.lonEditTxt);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                executeCall(AddCity.this);

                intent.putExtra("cNom",nom.getText().toString());
                intent.putExtra("cLon",lon.getText().toString());
                intent.putExtra("cLat",lat.getText().toString());

                setResult(RESULT_OK,intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
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
    public void doInBackground() {
        Ciudad aux= new Ciudad(nom.getText().toString(),lon.getText().toString(),lat.getText().toString());
        result= Connector.getConector().postDB(Ciudad.class,aux, API.Routes.CITY_ADD);

    }

    @Override
    public void doInUI() {
        if (result instanceof Result.Success){
            Toast.makeText(this, "Ciudad añadida", Toast.LENGTH_SHORT).show();
        }else{
            Result.Error error =(Result.Error)result;
            Toast.makeText(this, error.getError(), Toast.LENGTH_SHORT).show();
        }
    }
}