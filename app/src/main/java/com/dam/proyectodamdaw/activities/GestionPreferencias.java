package com.dam.proyectodamdaw.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dam.proyectodamdaw.R;

public class GestionPreferencias {
    private SharedPreferences pref;
    private static GestionPreferencias gestionPreferencias;

    private GestionPreferencias(){

    }

    public static GestionPreferencias getInstance(){
        if(gestionPreferencias==null)
            gestionPreferencias = new GestionPreferencias();
        return gestionPreferencias;
    }

    private void inicializa(Context context) {
        if (pref == null)
            pref = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getUnidades(Context context){
        inicializa(context);
        return pref.getString("unidades","standard");
    }

    public String getEditTextPreference(Context context){
        inicializa(context);
        return pref.getString("editTextPreferenceKey","389");
    }

    public boolean getCheckBoxPreference(Context context){
        inicializa(context);
        return pref.getBoolean("checkBoxPreferenceKey",false);
    }
//    public String getTheme(Context context){
//        inicializa(context);
//        return pref.getString(context.getString(R.string.settings_theme_key),ThemeSetup.Mode.DEFAULT.name());
//    }
}
