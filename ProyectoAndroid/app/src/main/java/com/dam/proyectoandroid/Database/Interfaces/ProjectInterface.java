package com.dam.proyectoandroid.Database.Interfaces;

import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProjectInterface {
    @GET("proyecto/all")
    Call<List<Proyecto>> getAll();

    @POST("proyecto/save")
    Call<Proyecto> create(@Body Proyecto proyecto);

}
