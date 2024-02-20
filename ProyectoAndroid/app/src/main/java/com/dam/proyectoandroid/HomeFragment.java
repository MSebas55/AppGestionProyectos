package com.dam.proyectoandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.ProjectInterface;
import com.dam.proyectoandroid.Database.adapters.ProjectAdapter;
import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {
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

        // Aquí añadimos el AlertDialog
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
        builder.setTitle(Html.fromHtml("<font color='#0F3800'>Crear nuevo Proyecto</font>"));

        // Inflar el layout personalizado
        View dialogView = getLayoutInflater().inflate(R.layout.alertdialog_home, null);
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
                ProjectAdapter proyectsAdapter = new ProjectAdapter(getContext(), proyectos);
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
