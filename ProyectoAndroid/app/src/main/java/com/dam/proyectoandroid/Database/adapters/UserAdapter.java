package com.dam.proyectoandroid.Database.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.R;
import com.dam.proyectoandroid.Database.model.Usuario;
import com.dam.proyectoandroid.TaskActivity;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private List<Usuario> usuarios;
    private Context context;

    // Constructor
    public UserAdapter(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_user, parent, false);
        return new UserViewHolder(view);
    }

    // Método llamado para rellenar los datos en una vista de elemento
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.nameText.setText(usuario.getNombre());
        holder.apellidoText.setText(usuario.getApellido());
        holder.emailText.setText(usuario.getEmail());

        // Establecer el OnClickListener para el itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes definir la acción al hacer clic en un elemento de usuario si es necesario
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuarios.size(); // Devolver el tamaño de la lista de usuarios
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, apellidoText, emailText;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nombre);
            apellidoText = itemView.findViewById(R.id.apellido);
            emailText = itemView.findViewById(R.id.email);
        }
    }
}
