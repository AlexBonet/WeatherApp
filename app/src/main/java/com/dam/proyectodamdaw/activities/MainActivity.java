package com.dam.proyectodamdaw.activities;

import android.os.Bundle;
import android.widget.ImageView;

import com.dam.proyectodamdaw.base.BaseActivity;
import com.dam.proyectodamdaw.base.CallInterface;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.base.ImageDownloader;

public class MainActivity extends BaseActivity implements CallInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void doInUI() {

    }
}