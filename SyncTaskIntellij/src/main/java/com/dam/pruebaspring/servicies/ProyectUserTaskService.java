package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.ProyectUserTask;
import com.dam.pruebaspring.repositories.ProyectUserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectUserTaskService {
    @Autowired
    private ProyectUserTaskRepository proyectUserTaskRepository;

    public List<ProyectUserTask> getAllProyectUserTasks() {
        return proyectUserTaskRepository.findAll();
    }
   /* public ProyectUserTask getProyectUserTaskById(Integer id){
        return proyectUserTaskRepository.findById(id).get();
    }*/

    public ProyectUserTask saveProyectUserTask(ProyectUserTask proyectUserTask) {
        return proyectUserTaskRepository.save(proyectUserTask);
    }
    /*public Boolean deleteProyectUserTask(Integer id){
        proyectUserTaskRepository.deleteById(id);

        return proyectUserTaskRepository.findById(id).isEmpty();
    }*/

}
