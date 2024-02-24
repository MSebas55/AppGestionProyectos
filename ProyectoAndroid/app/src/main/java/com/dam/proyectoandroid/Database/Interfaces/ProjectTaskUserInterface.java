package com.dam.proyectoandroid.Database.Interfaces;

import com.dam.proyectoandroid.Database.model.ProyectoTareaUsuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProjectTaskUserInterface {
    @GET("proyectUserTask/all")
    Call<List<ProyectoTareaUsuario>> getAll();

    @POST("proyectUserTask/save")
    Call<ProyectoTareaUsuario> create(@Body ProyectoTareaUsuario proyectoTareaUsuario);

    @PUT("proyectUserTask/update")
    Call<ProyectoTareaUsuario> update(@Body ProyectoTareaUsuario proyectoTareaUsuario);



}
