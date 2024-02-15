package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyectos_usuarios_tareas") // name tiene el nombre de la base de datos
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProyectUserTask {
    @EmbeddedId
    private ProyectUserTaskPK proyectUserTaskPK;

}
