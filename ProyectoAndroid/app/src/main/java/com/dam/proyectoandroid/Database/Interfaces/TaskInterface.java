package com.dam.proyectoandroid.Database.Interfaces;

import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.Tarea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TaskInterface {
    @GET("tarea/all")
    Call<List<Tarea>> getAll();
    @GET("tarea/getTareaByDay/{dia}")
    Call<List<Tarea>> getTareaByDay(@Path("dia") String dia);
    @POST("tarea/save")
    Call<Tarea> create(@Body Tarea tarea);
    @DELETE("tarea/delete/{id}")
    Call<Boolean> delete(@Path("id")Integer id);
    @PUT("tarea/update")
    Call<Tarea> update(@Body Tarea tarea);

}
