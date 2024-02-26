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

    @Column(name = "idusuario")
    private Integer idUsuario;
    @Column(name = "idtarea")
    private Integer idTarea;
    @Column(name = "idproyecto")
    private Integer idProyecto;

}
