package com.dam.proyectoandroid;

import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.HistoricEventRVAdapter;
import com.dam.proyectoandroid.R;

import java.util.ArrayList;
import java.util.Arrays;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.historicEventsRecycler);

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
        HistoricEventRVAdapter adapter = new HistoricEventRVAdapter(requireContext(), eventNames, eventDates, eventLocations, textColors);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return view;
    }

}
