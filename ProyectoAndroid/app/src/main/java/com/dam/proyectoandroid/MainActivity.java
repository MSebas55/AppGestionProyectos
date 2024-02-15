package com.dam.proyectoandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        RecyclerView recyclerView = findViewById(R.id.historicEventsRecycler);

        // Obtener las matrices de cadenas de los recursos de cadena
        String[] eventNamesArray = getResources().getStringArray(R.array.historic_event_names);
        String[] eventDatesArray = getResources().getStringArray(R.array.historic_event_dates);
        String[] eventLocationsArray = getResources().getStringArray(R.array.historic_event_locations);

        // Convertir las matrices en ArrayList
        ArrayList<String> eventNames = new ArrayList<>(Arrays.asList(eventNamesArray));
        ArrayList<String> eventDates = new ArrayList<>(Arrays.asList(eventDatesArray));
        ArrayList<String> eventLocations = new ArrayList<>(Arrays.asList(eventLocationsArray));
        ArrayList<String> textColors = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.text_colors)));

        // Crear y configurar el adaptador del RecyclerView
        HistoricEventRVAdapter adapter = new HistoricEventRVAdapter(this, eventNames, eventDates, eventLocations, textColors);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
