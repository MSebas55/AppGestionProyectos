package com.dam.proyectoandroid.Database.model;

public class ProyectoTareaUsuarioPK {
    private Integer idUsuario;
    private Integer idTarea;
    private Integer idProyecto;

    public ProyectoTareaUsuarioPK(Integer idUsuario, Integer idTarea, Integer idProyecto) {
        this.idUsuario = idUsuario;
        this.idTarea = idTarea;
        this.idProyecto = idProyecto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
}
