package com.dam.proyectoandroid.Database.Interfaces;

import android.location.Address;

import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProjectInterface {
    @GET("proyecto/all")
    Call<List<Proyecto>> getAll();
    @GET("proyecto/nombre/{nombre}")
    Call<Proyecto> getProjectByName(String nombre);
    @GET("proyecto/userProjects/{id}")
    Call<List<Proyecto>> getUserProjects(@Path("id") Integer id);

    @POST("proyecto/save")
    Call<Proyecto> create(@Body Proyecto proyecto);

    @PUT("proyecto/update")
    Call<Proyecto> update(@Body Proyecto proyecto);
    @DELETE("proyecto/delete/{id}")
    Call<Boolean> delete(@Path("id") Integer id);



}
