package com.dam.proyectoandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.TaskInterface;
import com.dam.proyectoandroid.Database.adapters.TaskAdapter;
import com.dam.proyectoandroid.Database.model.Tarea;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        recyclerView = view.findViewById(R.id.tasksRecycler);
        getAll();
        view.findViewById(R.id.floating_action_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
        return view;
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        // Establecer el título del AlertDialog y su color
        builder.setTitle(Html.fromHtml("<font color='#0F3800'>Crear nueva Tarea</font>"));

        // Inflar el layout personalizado
        View dialogView = getLayoutInflater().inflate(R.layout.alertdialog_task, null);
        builder.setView(dialogView);

        // Referenciar los campos del layout
        EditText editTextNombre = dialogView.findViewById(R.id.editTextNombre);
        EditText editTextDescripcion = dialogView.findViewById(R.id.editTextDescripcion);
        EditText editTextFechaFin = dialogView.findViewById(R.id.editTextFechaFin);

        // Configurar la fecha de inicio como la fecha actual
        // (Puedes cambiar el formato según tus necesidades)
        String fechaInicio = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

        // Configurar los campos según tus necesidades
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), fechaInicio, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
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