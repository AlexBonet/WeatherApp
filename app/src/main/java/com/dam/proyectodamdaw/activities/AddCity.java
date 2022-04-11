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

import com.dam.proyectodamdaw.R;

import java.util.LinkedList;

public class AddCity extends AppCompatActivity {

    private Button add;
    private Button cancel;
    private EditText nom;
    private EditText lat;
    private EditText lon;
    private Ciudad c;
    private LinkedList<Ciudad> newCityList=new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        add = findViewById(R.id.addButton);
        cancel = findViewById(R.id.cancelButton);
        nom = findViewById(R.id.nameEditTxt);
        lat = findViewById(R.id.latEditTxt);
        lon = findViewById(R.id.lonEditTxt);

        c = new Ciudad(nom.getText().toString(),lat.getText().toString(),
                lon.getText().toString(), R.mipmap.ciudad1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ChooseCity.class);
//                intent.putExtra("newCity",c);
                newCityList = (LinkedList<Ciudad>) getIntent().getExtras().get("lista");
                newCityList.add(c);
                intent.putExtra("newList",newCityList);
                startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ChooseCity.class);
                startActivity(intent);
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


}