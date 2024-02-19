package com.dam.proyectoandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.ProjectInterface;
import com.dam.proyectoandroid.Database.adapters.ProjectAdapter;
import com.dam.proyectoandroid.Database.model.Proyecto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment{
    RecyclerView recyclerView;
    static ProjectInterface projectInterface;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
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
        projectInterface = retrofit.create(ProjectInterface.class);

        Call<List<Proyecto>> call = projectInterface.getAll();
        call.enqueue(new Callback<List<Proyecto>>() {
            @Override
            public void onResponse(Call<List<Proyecto>> call, Response<List<Proyecto>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }

                List<Proyecto> proyectos = response.body();

                // Asignar el adaptador al RecyclerView
                ProjectAdapter proyectsAdapter = new ProjectAdapter(getContext(),proyectos);
                recyclerView.setAdapter(proyectsAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

            }

            @Override
            public void onFailure(Call<List<Proyecto>> call, Throwable t) {
                Log.e("Trow err: ", t.getMessage());
            }
        });
    }

}
