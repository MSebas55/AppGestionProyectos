package com.dam.pruebaspring.repositories;

import com.dam.pruebaspring.models.Proyecto;
import com.dam.pruebaspring.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    @Query(value = "SELECT * FROM tareas WHERE fechafin = ?1", nativeQuery = true)
    List<Tarea> getTareaByDay(String time);

}
