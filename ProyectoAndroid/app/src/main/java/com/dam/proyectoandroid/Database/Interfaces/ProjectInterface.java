package com.dam.proyectoandroid.Database.Interfaces;

import com.dam.proyectoandroid.Database.model.Proyecto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProjectInterface {
    @GET("proyecto/all")
    Call<List<Proyecto>> getAll();

}
