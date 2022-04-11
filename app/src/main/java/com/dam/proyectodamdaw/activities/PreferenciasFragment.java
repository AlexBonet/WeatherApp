package com.dam.proyectodamdaw.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.dam.proyectodamdaw.R;

import java.util.Arrays;
import java.util.List;

public class PreferenciasFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.prefes,rootKey);

        ListPreference listPreference = findPreference("unidades");

        List<String> entries = Arrays.asList(getResources().getStringArray(R.array.unidades_entries));
        List<String> values = Arrays.asList(getResources().getStringArray(R.array.unidades_values));

        String val = entries.get(values.indexOf(GestionPreferencias.getUnidad(getContext())));

        listPreference.setSummary("Seleccionado: " + val);

        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                String val = entries.get(values.indexOf(newValue));
                listPreference.setSummary("Seleccionado: " + val);
                return true;
            }
        });

    }
}