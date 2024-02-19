package com.dam.proyectoandroid;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.CRUDInterface;
import com.dam.proyectoandroid.Database.adapters.ProyectsAdapter;
import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.provisional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment{
    RecyclerView recyclerView;
    static CRUDInterface crudInterface;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.projectRecyclerView);
        getAll();

        return view;
    }

    public void getAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);

        Call<List<Proyecto>> call = crudInterface.getAll();
        call.enqueue(new Callback<List<Proyecto>>() {
            @Override
            public void onResponse(Call<List<Proyecto>> call, Response<List<Proyecto>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }
                // Obtener las matrices de cadenas de los recursos de cadena
                //ArrayList<String> eventNames = new ArrayList<>();
                //ArrayList<String> eventFechaFin = new ArrayList<>();
                List<Proyecto> proyectos = response.body();
                //ArrayList<String> textColors = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.text_colors)));

                // Asignar el adaptador al RecyclerView
                ProyectsAdapter proyectsAdapter = new ProyectsAdapter(getContext(),proyectos);
                recyclerView.setAdapter(proyectsAdapter);


                //Toast.makeText(getContext(), proyectos.get(0).getNombre(), Toast.LENGTH_SHORT).show();



                //for (Proyecto proyecto : proyectos) {
                //    eventNames.add(proyecto.getNombre());
                //    eventFechaFin.add(proyecto.getFechafin());
                //}

            }

            @Override
            public void onFailure(Call<List<Proyecto>> call, Throwable t) {
                Log.e("Trow err: ", t.getMessage());
            }
        });
    }

}
