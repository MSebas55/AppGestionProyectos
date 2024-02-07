package com.dam.pruebaspring.repositories;

import com.dam.pruebaspring.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Integer> {

}
