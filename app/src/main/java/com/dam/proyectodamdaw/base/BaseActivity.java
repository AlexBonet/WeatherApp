package com.dam.proyectodamdaw.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;

import com.dam.proyectodamdaw.api.Connector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected Connector connector;
    protected ExecutorService executor = Executors.newSingleThreadExecutor();
    protected Handler handler = new Handler(Looper.getMainLooper());
    protected MyProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connector = Connector.getConector();
        progressBar = new MyProgressBar(this);
    }

    protected void executeCall(CallInterface callInterface){
        executor.execute(() -> {
            callInterface.doInBackground();
            handler.post(() -> {
                callInterface.doInUI();
            });
        });
    }

    public void showProgress(){
        progressBar.show();
    }

    public void hideProgress(){
        progressBar.hide();
    }

    protected void setLayout(int layout){
        setContentView(layout);
        ViewGroup rootView = (ViewGroup) ((ViewGroup) this .findViewById(android.R.id.content)).getChildAt(0);
        progressBar.initControl(rootView);
        hideProgress();
    }

}
