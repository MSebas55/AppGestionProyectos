package com.dam.proyectoandroid.Database.Interfaces;

import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserInterface {
    @GET("usuario/all")
    Call<List<Usuario>> getAll();

    @POST("usuario/save")
    Call<Usuario> create(@Body Usuario usuario);

}
