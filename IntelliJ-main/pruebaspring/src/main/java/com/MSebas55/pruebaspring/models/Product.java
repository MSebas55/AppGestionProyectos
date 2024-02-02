package com.MSebas55.pruebaspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product") // Nombre de la tabla en la base de datos
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
}
