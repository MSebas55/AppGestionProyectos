package com.dam.proyectoandroid;

import static com.dam.proyectoandroid.LogReg.usuario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
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
import com.dam.proyectoandroid.Database.Interfaces.ProjectTaskUserInterface;
import com.dam.proyectoandroid.Database.Interfaces.TaskInterface;
import com.dam.proyectoandroid.Database.Interfaces.UserInterface;
import com.dam.proyectoandroid.Database.adapters.ProjectAdapter;
import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.ProyectoTareaUsuario;
import com.dam.proyectoandroid.Database.model.Tarea;
import com.dam.proyectoandroid.Database.model.Usuario;
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
    static TaskInterface taskInterface;
    static ProjectTaskUserInterface projectTaskUserInterface;

    EditText editTextNombre,editTextDescripcion,editTextFechaFin;
    String fechaInicio;
    AlertDialog.Builder builder;
    View dialogView;
    Proyecto proyecto;
    Tarea tarea;
    ProyectoTareaUsuario proyectoTareaUsuario;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.projectRecyclerView);
        getUserProjects();

        // Aquí añadimos el AlertDialog
        view.findViewById(R.id.floating_action_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogProject();
            }
        });

        return view;
    }

    private void showAlertDialogProject() {
        builder = new AlertDialog.Builder(requireContext());

        // Establecer el título del AlertDialog y su color
        builder.setTitle(Html.fromHtml("<font color='#0F3800'>Crear nuevo Proyecto</font>"));

        // Inflar el layout personalizado
        dialogView = getLayoutInflater().inflate(R.layout.alertdialog_home, null);
        builder.setView(dialogView);

        // Referenciar los campos del layout
        editTextNombre = dialogView.findViewById(R.id.editTextNombre);
        editTextDescripcion = dialogView.findViewById(R.id.editTextDescripcion);
        editTextFechaFin = dialogView.findViewById(R.id.editTextFechaFin);

        // Configurar la fecha de inicio como la fecha actual
        // (Puedes cambiar el formato según tus necesidades)
        fechaInicio = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        // Configurar los campos según tus necesidades
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showAlertDialogTarea();
                proyecto = crearProyecto();
                Toast.makeText(getContext(), "Crea minimo una tarea", Toast.LENGTH_SHORT).show();
            }
        });


        builder.create().show();
    }
    private void showAlertDialogTarea() {
        builder = new AlertDialog.Builder(requireContext());

        // Establecer el título del AlertDialog y su color
        builder.setTitle(Html.fromHtml("<font color='#0F3800'>Crear nueva Tarea</font>"));

        // Inflar el layout personalizado
        dialogView = getLayoutInflater().inflate(R.layout.alertdialog_task, null);
        builder.setView(dialogView);

        // Referenciar los campos del layout
        editTextNombre = dialogView.findViewById(R.id.editTextNombre);
        editTextDescripcion = dialogView.findViewById(R.id.editTextDescripcion);
        editTextFechaFin = dialogView.findViewById(R.id.editTextFechaFin);

        // Configurar la fecha de inicio como la fecha actual
        // (Puedes cambiar el formato según tus necesidades)
        fechaInicio = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

        // Configurar los campos según tus necesidades
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tarea = crearTarea();
                addTask(tarea);
                addProject(proyecto);
                addProjectTaskUser(crearProyectoTareaUsuario());


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

    public Proyecto crearProyecto(){
        Proyecto proyecto = new Proyecto(editTextNombre.getText().toString()
                ,"En progreso", editTextDescripcion.getText().toString(),
                fechaInicio, editTextFechaFin.getText().toString());
        return proyecto;
    }
    public Tarea crearTarea(){
        Tarea tarea = new Tarea(editTextNombre.getText().toString()
                ,"En progreso", editTextDescripcion.getText().toString(),
                fechaInicio, editTextFechaFin.getText().toString());
        return tarea;
    }
    public ProyectoTareaUsuario crearProyectoTareaUsuario(){
        ProyectoTareaUsuario proyectoTareaUsuario =
                new ProyectoTareaUsuario(usuario.getId(),tarea.getId(),proyecto.getId());
        return proyectoTareaUsuario;
    }

    public void addProject(Proyecto p) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        projectInterface = retrofit.create(ProjectInterface.class);


        Call<Proyecto> call = projectInterface.create(p);
        call.enqueue(new Callback<Proyecto>() {
            @Override
            public void onResponse(Call<Proyecto> call, Response<Proyecto> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "no respuesta", Toast.LENGTH_SHORT).show();
                    return;
                }
                proyecto = response.body();
                Toast.makeText(getContext(), "Proyecto creado", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Proyecto> call, Throwable t) {
                Toast.makeText(getContext(), "no conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void addTask(Tarea t) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        taskInterface = retrofit.create(TaskInterface.class);


        Call<Tarea> call = taskInterface.create(t);
        call.enqueue(new Callback<Tarea>() {
            @Override
            public void onResponse(Call<Tarea> call, Response<Tarea> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "no respuesta", Toast.LENGTH_SHORT).show();
                    return;
                }
                tarea = response.body();
                Toast.makeText(getContext(), "Tarea creada", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Tarea> call, Throwable t) {
                Toast.makeText(getContext(), "no conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void addProjectTaskUser(ProyectoTareaUsuario proyectoTareaUsuario) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        projectTaskUserInterface = retrofit.create(ProjectTaskUserInterface.class);


        Call<ProyectoTareaUsuario> call = projectTaskUserInterface.create(proyectoTareaUsuario);
        call.enqueue(new Callback<ProyectoTareaUsuario>() {
            @Override
            public void onResponse(Call<ProyectoTareaUsuario> call, Response<ProyectoTareaUsuario> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "no respuesta", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getContext(), "Conexion creada", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ProyectoTareaUsuario> call, Throwable t) {
                Toast.makeText(getContext(), "no conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getUserProjects() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        projectInterface = retrofit.create(ProjectInterface.class);

        Call<List<Proyecto>> call = projectInterface.getUserProjects(usuario.getId());
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
