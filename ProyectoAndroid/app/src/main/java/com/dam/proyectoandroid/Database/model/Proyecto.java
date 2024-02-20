package com.dam.proyectoandroid.Database.model;

import androidx.annotation.NonNull;

public class Proyecto {
    private Integer id;
    private String nombre;
    private String estado;
    private String descripcion;
    private String fechaini;
    private String fechafin;

    public Proyecto() {
    }

    public Proyecto(String nombre, String estado, String descripcion, String fechaini, String fechafin) {
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaini = fechaini;
        this.fechafin = fechafin;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaini() {
        return fechaini;
    }

    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
