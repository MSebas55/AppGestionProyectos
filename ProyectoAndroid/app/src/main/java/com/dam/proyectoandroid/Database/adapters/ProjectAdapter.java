package com.dam.proyectoandroid.Database.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.ProjectActivity;
import com.dam.proyectoandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private List<Proyecto> proyectos;
    private Context context;
    public static Proyecto proyectoElegido;

    // Constructor
    public ProjectAdapter(Context context, List<Proyecto> proyectos) {
        this.context = context;
        this.proyectos = proyectos;

    }

    // Método llamado cuando se necesita crear una nueva vista de elemento
    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_project, parent, false);
        return new ProjectViewHolder(view);
    }

    // Método llamado para rellenar los datos en una vista de elemento
    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Proyecto proyecto = proyectos.get(position);
        holder.nameText.setText(proyecto.getNombre());
        holder.fechaFinText.setText("Fecha de entrega: " + proyecto.getFechafin());
        // Aquí puedes establecer cualquier otro dato que necesites

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes iniciar la actividad "Proyecto"
                proyectoElegido = proyecto;
                Intent intent = new Intent(context, ProjectActivity.class);
                context.startActivity(intent);
            }
        });
    }

    // Devuelve el número total de elementos en el conjunto de datos
    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    // Clase interna para mantener las referencias de las vistas de cada elemento del RecyclerView
    public static class ProjectViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView fechaFinText;


        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.tvEventName);
            fechaFinText = itemView.findViewById(R.id.tvEventFechaFin);
        }

    }
}
