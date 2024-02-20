package com.dam.proyectoandroid.Database.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.R;
import com.dam.proyectoandroid.Database.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {

    private List<Usuario> usuarios;
    private Context context;

    // Constructor
    public UserAdapter(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;

    }


}
