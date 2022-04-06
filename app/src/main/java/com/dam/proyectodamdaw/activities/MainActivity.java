package com.dam.proyectodamdaw.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.api.Connector;
import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;
import com.dam.proyectodamdaw.R;

public class MainActivity extends BaseActivity implements CallInterface, View.OnClickListener {
    Root root;
    String url = "forecast?lang=es&units=metric&lat=39.6217623&lon=-0.5955436&appid=610ef1ab429f1c7c4bb6021fdfa5b2c0";
    private RecyclerView recyclerView;
    private TextView nomCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main);


        nomCiudad = findViewById(R.id.nomCiudad);
        nomCiudad.setText(getIntent().getExtras().getString("city"));
        recyclerView = findViewById(R.id.recycler);
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
}