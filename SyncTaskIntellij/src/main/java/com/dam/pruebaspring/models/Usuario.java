package com.dam.pruebaspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Entity
@Table(name = "usuarios") // name tiene el nombre de la base de datos
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Usuario {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;
    @Column(name = "contra")
    private String contra;
    @Column(name = "email")
    private String email;
}
