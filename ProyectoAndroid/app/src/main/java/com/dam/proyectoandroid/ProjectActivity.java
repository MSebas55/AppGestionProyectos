package com.dam.proyectoandroid;

import static com.dam.proyectoandroid.Database.adapters.ProjectAdapter.proyectoElegido;
import static com.dam.proyectoandroid.HomeFragment.proyecto;
import static com.dam.proyectoandroid.LogReg.usuario;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.ProjectInterface;
import com.dam.proyectoandroid.Database.Interfaces.ProjectTaskUserInterface;
import com.dam.proyectoandroid.Database.Interfaces.TaskInterface;
import com.dam.proyectoandroid.Database.adapters.TaskAdapter;
import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.ProyectoTareaUsuario;
import com.dam.proyectoandroid.Database.model.ProyectoTareaUsuarioPK;
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

public class ProjectActivity extends AppCompatActivity {
    TextView fechaFin, fechaIni, nombre, descripcion;
    Button addUsuario,deleteTarea;
    TaskInterface taskInterface;
    ProjectInterface projectInterface;
    ProjectTaskUserInterface projectTaskUserInterface;
    RecyclerView recyclerView;
    AlertDialog.Builder builder;
    Tarea tarea;
    View dialogView;
    ProyectoTareaUsuario proyectoTareaUsuario;
    ProyectoTareaUsuarioPK proyectoTareaUsuarioPK;
    EditText editTextNombre,editTextDescripcion,editTextFechaFin;
    String fechaInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyect);

        // Referencias a las vistas
        fechaFin = findViewById(R.id.fechafin);
        fechaIni = findViewById(R.id.fechaini);
        nombre = findViewById(R.id.nombreproyecto);
        descripcion = findViewById(R.id.descripcion);
        recyclerView = findViewById(R.id.tasksRecycler);
        addUsuario = findViewById(R.id.addTarea);
        deleteTarea = findViewById(R.id.deleteProyecto);
        fechaInicio = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        addUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogTarea();
            }
        });
        deleteTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProject();
                Intent intent = new Intent(ProjectActivity.this,Inicio.class);
                startActivity(intent);

            }
        });

        // Configuración del RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener las tareas del proyecto
        getTasks();

        // Mostrar los detalles del proyecto
        showProjectDetails();
    }

    private void showProjectDetails() {
        fechaFin.setText("Fecha de entrega: " + proyectoElegido.getFechafin());
        fechaIni.setText("Fecha de inicio: " + proyectoElegido.getFechaini());
        nombre.setText(proyectoElegido.getNombre());
        descripcion.setText(proyectoElegido.getDescripcion());
    }

    public void showAlertDialogTarea() {
        builder = new AlertDialog.Builder(this);

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

        // Configurar los campos según tus necesidades
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                crearTarea();
                addTask(tarea);

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

    private void getTasks() {
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
                TaskAdapter tasksAdapter = new TaskAdapter(ProjectActivity.this, tareas);
                recyclerView.setAdapter(tasksAdapter);
            }

            @Override
            public void onFailure(Call<List<Tarea>> call, Throwable t) {
                Log.e("Trow err: ", t.getMessage());
            }
        });
    }
    private void deleteProject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        projectInterface = retrofit.create(ProjectInterface.class);

        Call<Boolean> call = projectInterface.delete(proyectoElegido.getId());
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.e("Trow err: ", t.getMessage());
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
                    Toast.makeText(getApplicationContext(), "no respuesta", Toast.LENGTH_SHORT).show();
                    return;
                }
                tarea = response.body();
                Toast.makeText(getApplicationContext(), "Tarea creada", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Tarea> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "no conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Tarea crearTarea(){
        tarea = new Tarea(editTextNombre.getText().toString()
                ,"En progreso", editTextDescripcion.getText().toString(),
                fechaInicio, editTextFechaFin.getText().toString());
        return tarea;
    }
    public ProyectoTareaUsuario crearProyectoTareaUsuario(){
        proyectoTareaUsuarioPK =
                new ProyectoTareaUsuarioPK(usuario.getId(),tarea.getId(),proyecto.getId());
        proyectoTareaUsuario =
                new ProyectoTareaUsuario(proyectoTareaUsuarioPK);
        return proyectoTareaUsuario;
    }
}
