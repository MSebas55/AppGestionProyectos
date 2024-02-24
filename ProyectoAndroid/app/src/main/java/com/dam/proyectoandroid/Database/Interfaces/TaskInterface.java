package com.dam.proyectoandroid.Database.Interfaces;

import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.Tarea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TaskInterface {
    @GET("tarea/all")
    Call<List<Tarea>> getAll();
    @POST("tarea/save")
    Call<Tarea> create(@Body Tarea tarea);

}
