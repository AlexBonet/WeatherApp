package com.dam.proyectodamdaw.activities;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.dam.proyectodamdaw.R;

public class GestionPreferencias {
    private static SharedPreferences preferences;

    private GestionPreferencias(){}

    public static String getUnidad(Context context){
        inicializa(context);
        return preferences.getString("unidades","standard");
    }
    public static String getTema(Context context){
        inicializa(context);
        return preferences.getString("temas","DEFAULT");
    }
    public static String getIdioma(Context context){
        inicializa(context);
        return preferences.getString("idiomas","ESPAÑOL");
    }

    private static void inicializa(Context context) {
        if (preferences == null)
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
}
