package com.dam.proyectoandroid.Database.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.R;

import java.util.List;

public class ProyectsAdapter extends BaseAdapter {

    List<Proyecto> proyectos;

    Context context;
    TextView nameText;
    Button viewButon;

    public ProyectsAdapter(List<Proyecto> proyectos, Context context) {
    }

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
        holder.fechaFinText.setText("Fecha máxima de entrega: " + proyecto.getFechafin());
        // Aquí puedes establecer cualquier otro dato que necesites
    }

    // Devuelve el número total de elementos en el conjunto de datos
    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    @Override
    public Object getItem(int i) {
        return proyectos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return proyectos.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.activity_proyect,viewGroup,false);

        }
        //nameText = view.findViewById(R.id.nameText);
        nameText.setText(proyectos.get(position).getNombre());
        //viewButon = view.findViewById(R.id.viewButton);
        return view;
    }
}
