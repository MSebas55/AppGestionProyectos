package com.dam.proyectoandroid.Database.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ProyectsAdapter extends RecyclerView.Adapter<ProyectsAdapter.ProyectViewHolder> {

    private List<Proyecto> proyectos;
    private ArrayList<String> textColors;
    private Context context;

    // Constructor
    public ProyectsAdapter(Context context, List<Proyecto> proyectos) {
        this.context = context;
        this.proyectos = proyectos;

    }

    // Método llamado cuando se necesita crear una nueva vista de elemento
    @NonNull
    @Override
    public ProyectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_row, parent, false);
        return new ProyectViewHolder(view);
    }

    // Método llamado para rellenar los datos en una vista de elemento
    @Override
    public void onBindViewHolder(@NonNull ProyectViewHolder holder, int position) {
        Proyecto proyecto = proyectos.get(position);
        holder.nameText.setText(proyecto.getNombre());
        // Aquí puedes establecer cualquier otro dato que necesites
    }

    // Devuelve el número total de elementos en el conjunto de datos
    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    // Clase interna para mantener las referencias de las vistas de cada elemento del RecyclerView
    public static class ProyectViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView fechaFinText;


        public ProyectViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.tvEventName);
            fechaFinText = itemView.findViewById(R.id.tvEventFechaFin);
        }

    }
}
