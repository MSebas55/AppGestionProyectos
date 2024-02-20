package com.dam.proyectoandroid.Database.model;

import androidx.annotation.NonNull;

public class Usuario {
    private Integer id;
    private String nombre;
    private String apellido;
    private String contra;
    private String email;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String apellido, String contra, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contra = contra;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
