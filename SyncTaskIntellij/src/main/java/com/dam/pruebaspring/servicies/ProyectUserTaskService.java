package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.ProyectUserTask;
import com.dam.pruebaspring.repositories.ProyectUserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectUserTaskService {
    private final ProyectUserTaskRepository proyectUserTaskRepository;
    @Autowired
    public ProyectUserTaskService(ProyectUserTaskRepository proyectUserTaskRepository) {
        this.proyectUserTaskRepository = proyectUserTaskRepository;
    }

    public List<ProyectUserTask> getAllProyectUserTasks() {
        return proyectUserTaskRepository.findAll();
    }


    public ProyectUserTask saveProyectUserTask(ProyectUserTask proyectUserTask) {
        return proyectUserTaskRepository.save(proyectUserTask);

    }

    /*public Boolean deleteProyectUserTask(Integer id){
        proyectUserTaskRepository.deleteById(id);

        return proyectUserTaskRepository.findById(id).isEmpty();
    }*/

}
