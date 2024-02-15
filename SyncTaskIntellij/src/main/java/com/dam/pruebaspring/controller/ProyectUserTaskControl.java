package com.dam.pruebaspring.controller;

import com.dam.pruebaspring.models.ProyectUserTask;
import com.dam.pruebaspring.servicies.ProyectUserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectUserTask")
public class ProyectUserTaskControl {
    @Autowired
    private ProyectUserTaskService proyectUserTaskService;

    @GetMapping("/all")
    public List<ProyectUserTask> getAllProyectUserTasks() {
        return proyectUserTaskService.getAllProyectUserTasks();
    }
    /*@GetMapping("/id/{id}")
    public ProyectUserTask getProyectUserTaskById(@PathVariable Integer id){
        return proyectUserTaskService.getProyectUserTaskById(id);
    }*/

    @PostMapping("/save")
    public ProyectUserTask saveProyectUserTask(@RequestBody ProyectUserTask proyectUserTask) {
        return proyectUserTaskService.saveProyectUserTask(proyectUserTask);
    }

    @PutMapping("/update")
    public ProyectUserTask updateProyectUserTask(@RequestBody ProyectUserTask proyectUserTask) {
        return proyectUserTaskService.saveProyectUserTask(proyectUserTask);
    }

    /*@DeleteMapping("/delete/{id}")
    public Boolean deleteProyectUserTask(@PathVariable Integer id){
        return proyectUserTaskService.deleteProyectUserTask(id);
    }*/
}
