package com.dam.pruebaspring.repositories;

import com.dam.pruebaspring.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    Proyecto findByNombre(String nombre);
}
