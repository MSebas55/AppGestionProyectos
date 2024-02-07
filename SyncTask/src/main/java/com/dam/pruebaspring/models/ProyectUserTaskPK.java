package com.dam.pruebaspring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class ProyectUserTaskPK {
    @Column(name = "idProyecto")
    private Integer idProyecto;
    @Column(name = "idTarea")
    private Integer idTarea;
    @Column(name = "idUsuario")
    private Integer idUsuario;
}
