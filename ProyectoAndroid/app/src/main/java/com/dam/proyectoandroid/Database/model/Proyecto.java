package com.dam.proyectoandroid.Database.model;

import androidx.annotation.NonNull;

public class Proyecto {
    private Integer id;
    private String nombre;
    private String estado;
    private String descripción;
    private String fechaini;
    private String fechafin;

    public Proyecto() {
    }

    public Proyecto(Integer id, String nombre, String estado, String descripción, String fechaini, String fechafin) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.descripción = descripción;
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

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
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
