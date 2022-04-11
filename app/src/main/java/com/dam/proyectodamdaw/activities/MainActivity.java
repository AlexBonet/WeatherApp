package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.Parameters;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;
import com.dam.proyectodamdaw.R;

public class MainActivity extends BaseActivity implements CallInterface, View.OnClickListener {
    Root root;
//    String url = "forecast?lang=es&units=metric&lat=39.6217623&lon=-0.5955436&appid=610ef1ab429f1c7c4bb6021fdfa5b2c0";
    Ciudad ciudad;
    String lat;
    String lon;
    String url;
    private RecyclerView recyclerView;
    private TextView nomCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main);

        nomCiudad = findViewById(R.id.nomCiudad);
        nomCiudad.setText(getIntent().getExtras().getString("nom"));
        recyclerView = findViewById(R.id.recycler);
        ciudad = (Ciudad) getIntent().getExtras().getSerializable("city");
        lat = ciudad.getLat();
        lon = ciudad.getLon();
        url = "forecast?lang=" + "es" + "&units=" + "metric" + "&lat=" + lat + "&lon=" + lon + Parameters.URL_post_lon;
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress();
        executeCall(this);
    }

    @Override
    public void doInBackground() {
        root = Connector.getConector().get(Root.class,url);
    }

    @Override
    public void doInUI() {
        hideProgress();

        MyRVAdapter myRecyclerViewAdapter = new MyRVAdapter(this,root);
        myRecyclerViewAdapter.setOnClickListener(this);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLinearLayoutManager);
    }

    @Override
    public void onClick(View view) {
        int posi = recyclerView.getChildAdapterPosition(view);
        Intent intent = new Intent(getApplicationContext(),VistaExtendida.class);
        intent.putExtra("root",root.list.get(posi));
        startActivity(intent);

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

// onSaveInstanceState +  onRestoreInstanceState


//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putSerializable("rootE",root);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        recyclerView.setAdapter((RecyclerView.Adapter) savedInstanceState.get("rootE"));
//    }
}