package com.dam.proyectoandroid.Database.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.Database.model.Tarea;
import com.dam.proyectoandroid.R;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Tarea> tareas;
    private ArrayList<String> textColors;
    private Context context;

    // Constructor
    public TaskAdapter(Context context, List<Tarea> tareas) {
        this.context = context;
        this.tareas = tareas;

    }

    // Método llamado cuando se necesita crear una nueva vista de elemento
    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_row, parent, false);
        return new TaskViewHolder(view);
    }

    // Método llamado para rellenar los datos en una vista de elemento
    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Tarea tarea = tareas.get(position);
        holder.nameText.setText(tarea.getNombre());
        holder.fechaFinText.setText("Fecha máxima de entrega: " + tarea.getFechafin());
        // Aquí puedes establecer cualquier otro dato que necesites
    }

    // Devuelve el número total de elementos en el conjunto de datos
    @Override
    public int getItemCount() {
        return tareas.size();
    }

    // Clase interna para mantener las referencias de las vistas de cada elemento del RecyclerView
    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView fechaFinText;


        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.tvEventName);
            fechaFinText = itemView.findViewById(R.id.tvEventFechaFin);
        }

    }
}
