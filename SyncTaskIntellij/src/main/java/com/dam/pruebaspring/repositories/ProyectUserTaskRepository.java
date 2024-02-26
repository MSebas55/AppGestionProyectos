package com.dam.pruebaspring.repositories;

import com.dam.pruebaspring.models.ProyectUserTask;
import com.dam.pruebaspring.models.ProyectUserTaskPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectUserTaskRepository extends JpaRepository<ProyectUserTask, ProyectUserTaskPK> {
}
