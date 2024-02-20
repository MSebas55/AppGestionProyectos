package com.dam.proyectoandroid.Database.Interfaces;

import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserInterface {
    @GET("usuario/all")
    Call<List<Usuario>> getAll();

    @GET("usuario/nombre/{nombre}")
    Call<Usuario> getUserByName(String nombre);

    @GET("usuario/email/{email}")
    Call<Usuario> getUserByEmail(@Path("email") String email);

    @POST("usuario/save")
    Call<Usuario> create(@Body Usuario usuario);



}
