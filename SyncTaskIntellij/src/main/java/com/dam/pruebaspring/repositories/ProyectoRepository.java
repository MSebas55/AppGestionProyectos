package com.dam.pruebaspring.repositories;

import com.dam.pruebaspring.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Parameter;
import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    Proyecto findByNombre(String nombre);


    @Query(value = "SELECT proyectos.* " +
            "FROM proyectos " +
            "JOIN proyectos_usuarios_tareas ON proyectos.id = proyectos_usuarios_tareas.idProyecto " +
            "JOIN usuarios ON proyectos_usuarios_tareas.idUsuario = usuarios.id " +
            "WHERE usuarios.id = %:id%;",nativeQuery = true)
    List<Proyecto> search(@Param("id") Integer id);
}
