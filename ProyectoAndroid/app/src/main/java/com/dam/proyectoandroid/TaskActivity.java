package com.dam.proyectoandroid;

import static com.dam.proyectoandroid.Database.adapters.ProjectAdapter.proyectoElegido;
import static com.dam.proyectoandroid.Database.adapters.TaskAdapter.tarea;
import static com.dam.proyectoandroid.HomeFragment.proyecto;
import static com.dam.proyectoandroid.HomeFragment.taskInterface;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.ProjectInterface;
import com.dam.proyectoandroid.Database.Interfaces.ProjectTaskUserInterface;
import com.dam.proyectoandroid.Database.Interfaces.TaskInterface;
import com.dam.proyectoandroid.Database.Interfaces.UserInterface;
import com.dam.proyectoandroid.Database.adapters.TaskAdapter;
import com.dam.proyectoandroid.Database.adapters.UserAdapter;
import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.ProyectoTareaUsuario;
import com.dam.proyectoandroid.Database.model.ProyectoTareaUsuarioPK;
import com.dam.proyectoandroid.Database.model.Tarea;
import com.dam.proyectoandroid.Database.model.Usuario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaskActivity extends AppCompatActivity {
    TextView fechaFin, fechaIni, nombre, descripcion;
    Button addUsuario,deleteTarea;
    ProjectInterface projectInterface;
    ProjectTaskUserInterface projectTaskUserInterface;
    RecyclerView recyclerView;
    ProyectoTareaUsuario proyectoTareaUsuario;
    ProyectoTareaUsuarioPK proyectoTareaUsuarioPK;
    String fechaInicio;
    UserInterface userInterface;
    CheckBox estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        // Referencias a las vistas
        fechaFin = findViewById(R.id.fechafin);
        fechaIni = findViewById(R.id.fechaini);
        nombre = findViewById(R.id.nobreTarea);
        descripcion = findViewById(R.id.descripcion);
        addUsuario = findViewById(R.id.addUsuario);
        deleteTarea = findViewById(R.id.deleteTarea);
        estado = findViewById(R.id.checkBox);
        fechaInicio = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        recyclerView = findViewById(R.id.usersRecycler);

        if(tarea.getEstado().equals("Acabado")){
            estado.setChecked(true);
            estado.setText("Acabado");
        }else{
            estado.setText("En progreso");
        }

        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(estado.isChecked()){
                    estado.setText("Acabado");
                }else{
                    estado.setText("En progreso");
                }
                actualizarTarea(estado.getText().toString());
                updateTask(tarea);

            }
        });
        addUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        deleteTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteTask();

                try {
                    Intent intent = new Intent(TaskActivity.this,ProjectActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(TaskActivity.this,Inicio.class);
                    startActivity(intent);
                }

            }
        });

        // Configuración del RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener las tareas del proyecto
        getUsers();

        // Mostrar los detalles del proyecto
        showTaskDetails();
    }

    private void showTaskDetails() {
        fechaFin.setText("Fecha de entrega: " + tarea.getFechafin());
        fechaIni.setText("Fecha de inicio: " + tarea.getFechaini());
        nombre.setText(tarea.getNombre());
        descripcion.setText(tarea.getDescripcion());
    }
    public Tarea actualizarTarea(String estado){
        tarea.setEstado(estado);
        return tarea;
    }
    public void updateTask(Tarea t) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        taskInterface = retrofit.create(TaskInterface.class);


        Call<Tarea> call = taskInterface.update(t);
        call.enqueue(new Callback<Tarea>() {
            @Override
            public void onResponse(Call<Tarea> call, Response<Tarea> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "no respuesta", Toast.LENGTH_SHORT).show();
                    return;
                }
                tarea = response.body();
                Toast.makeText(getApplicationContext(), "Tarea actualizada", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Tarea> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "no conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUsers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userInterface = retrofit.create(UserInterface.class);

        Call<List<Usuario>> call = userInterface.getAll();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }

                List<Usuario> usuarios = response.body();

                // Asignar el adaptador al RecyclerView
                UserAdapter userAdapter = new UserAdapter(TaskActivity.this, usuarios);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Log.e("Trow err: ", t.getMessage());
            }
        });
    }

    private void deleteTask() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        taskInterface = retrofit.create(TaskInterface.class);

        Call<Boolean> call = taskInterface.delete(tarea.getId());
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful() && response.body() != null && response.body()) {
                    // La tarea se eliminó correctamente
                    Toast.makeText(TaskActivity.this, "Tarea eliminada correctamente", Toast.LENGTH_SHORT).show();
                    // Aquí puedes realizar cualquier otra acción necesaria después de eliminar la tarea
                } else {
                    // La eliminación de la tarea falló
                    Log.e("Delete Task", "Error al eliminar la tarea");
                    Toast.makeText(TaskActivity.this, "Error al eliminar la tarea", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                // Error al realizar la llamada Retrofit para eliminar la tarea
                Log.e("Delete Task", "Error al eliminar la tarea: " + t.getMessage());
                Toast.makeText(TaskActivity.this, "Error al eliminar la tarea: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}