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

        ListPreference listPreferenceVal = findPreference("unidades");
        ListPreference listPreferenceTem = findPreference("temas");
        ListPreference listPreferenceIdi = findPreference("idiomas");

        List<String> entriesVal = Arrays.asList(getResources().getStringArray(R.array.unidades_entries));
        List<String> entriesTem = Arrays.asList(getResources().getStringArray(R.array.settings_theme_entries));
        List<String> entriesIdi = Arrays.asList(getResources().getStringArray(R.array.idiomas_entries));
        List<String> valuesVal = Arrays.asList(getResources().getStringArray(R.array.unidades_values));
        List<String> valuesTem = Arrays.asList(getResources().getStringArray(R.array.settings_theme_values));
        List<String> valuesIdi = Arrays.asList(getResources().getStringArray(R.array.idiomas_values));

        String val = entriesVal.get(valuesVal.indexOf(GestionPreferencias.getUnidad(getContext())));
        String tema = entriesTem.get(valuesTem.indexOf(GestionPreferencias.getTema(getContext())));
        String idioma = entriesIdi.get(valuesIdi.indexOf(GestionPreferencias.getIdioma(getContext())));

        listPreferenceVal.setSummary("Unidad seleccionada: " + val);
        listPreferenceTem.setSummary("Tema seleccionada: " + tema);
        listPreferenceIdi.setSummary("Idioma seleccionada: " + idioma);

        listPreferenceVal.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                String val = entriesVal.get(valuesVal.indexOf(newValue));
                listPreferenceVal.setSummary("Unidad seleccionada: " + val);
                return true;
            }
        });

        listPreferenceTem.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                String tem = entriesTem.get(valuesTem.indexOf(newValue));
                listPreferenceTem.setSummary("Tema seleccionada: " + tem);
                return true;
            }
        });

        listPreferenceIdi.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                String idi = entriesIdi.get(valuesIdi.indexOf(newValue));
                listPreferenceIdi.setSummary("Idioma seleccionada: " + idi);
                return true;
            }
        });
    }
}