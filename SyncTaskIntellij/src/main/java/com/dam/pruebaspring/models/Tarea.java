package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tareas") // name tiene el nombre de la base de datos
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Tarea {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private String estado;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechaini")
    private String fechaini;
    @Column(name = "fechafin")
    private String fechafin;
    @Column(name = "proyecto_id")
    private Integer proyectoId;
}
