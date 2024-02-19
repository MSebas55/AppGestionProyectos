package com.dam.proyectoandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.TaskInterface;
import com.dam.proyectoandroid.Database.adapters.TaskAdapter;
import com.dam.proyectoandroid.Database.model.Tarea;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class TaskFragment extends Fragment {

    RecyclerView recyclerView;
    TaskInterface taskInterface;
    public TaskFragment() {
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
        taskInterface = retrofit.create(TaskInterface.class);

        Call<List<Tarea>> call = taskInterface.getAll();
        call.enqueue(new Callback<List<Tarea>>() {
            @Override
            public void onResponse(Call<List<Tarea>> call, Response<List<Tarea>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }

                List<Tarea> tareas = response.body();

                // Asignar el adaptador al RecyclerView
                TaskAdapter tasksAdapter = new TaskAdapter(getContext(),tareas);
                recyclerView.setAdapter(tasksAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

            }

            @Override
            public void onFailure(Call<List<Tarea>> call, Throwable t) {
                Log.e("Trow err: ", t.getMessage());
            }
        });
    }
}