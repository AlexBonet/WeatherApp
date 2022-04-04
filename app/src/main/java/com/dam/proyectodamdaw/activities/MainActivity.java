package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.Parameters;
import com.dam.proyectodamdaw.Recycler.Model;
import com.dam.proyectodamdaw.Recycler.MyRVAdapter;
import com.dam.proyectodamdaw.Recycler.WeatherOne;
import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.base.ImageDownloader;

import java.net.ConnectException;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements CallInterface, View.OnClickListener {
    Root root;
    String url = "forecast?lang=es&units=metric&lat=39.6217623&lon=-0.5955436&appid=610ef1ab429f1c7c4bb6021fdfa5b2c0";
    private RecyclerView recyclerView;
    private TextView nomCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main);

//        ImageView imageView=findViewById(R.id.ima);
//        ImageDownloader.DownloadImage(Parameters.URL_icon_pre+"03d"+Parameters.URL_icon_pos,imageView);
        recyclerView = findViewById(R.id.recycler);
        nomCiudad = findViewById(R.id.nomCiudad);
        nomCiudad.setText(getIntent().getExtras().getString("city"));

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
        Connector c = new Connector();

// hem de llevar el Model
//        MyRVAdapter myRecyclerViewAdapter = new MyRVAdapter(this, Model.getInstance().getList());

        MyRVAdapter myRecyclerViewAdapter = new MyRVAdapter(this,c.getAsList(root.,url));
        myRecyclerViewAdapter.setOnClickListener(this);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLinearLayoutManager);
    }

    @Override
    public void onClick(View view) {
        WeatherOne w= Model.getInstance().getList().get(recyclerView.getChildAdapterPosition(view));
        Toast.makeText(this,"Prevision para el " + w.getDia() + " a las " + w.getHora(),Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(),VistaExtendida.class);
        intent.putExtra("hora",w.getHora());
        intent.putExtra("fecha",w.getFecha());
        intent.putExtra("grTemp",w.getGradosTemp());
        intent.putExtra("grMax",w.getGradosMax());
        intent.putExtra("grMin",w.getGradosMin());
        intent.putExtra("humedad",w.getHumedad());
        intent.putExtra("grSens",w.getSensacionTermica());

        startActivity(intent);

    }
}