package com.dam.pruebaspring.controller;

import com.dam.pruebaspring.models.Proyecto;
import com.dam.pruebaspring.models.Tarea;
import com.dam.pruebaspring.servicies.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaControl {
    @Autowired
    private TareaService tareaService;

    @GetMapping("/all")
    public List<Tarea> getAllTareas() {
        return tareaService.getAllTareas();
    }

    @GetMapping("/id/{id}")
    public Tarea getTareaById(@PathVariable Integer id) {
        return tareaService.getTareaById(id);
    }

    @GetMapping("/getTareaByDay/{time}")
    /*public ResponseEntity<?> getTareaByDay(@PathVariable String time){
        return ResponseEntity.status(HttpStatus.OK).body(tareaService.getTareaByDay(time));
    }*/
    public List<Tarea> getTareaByDay(@PathVariable String time) {
        return tareaService.getTareaByDay(time);
    }

    @PostMapping("/save")
    public Tarea saveTarea(@RequestBody Tarea tarea) {

        return tareaService.saveTarea(tarea);
    }

    @PutMapping("/update")
    public Tarea updateTarea(@RequestBody Tarea tarea) {
        return tareaService.saveTarea(tarea);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteTarea(@PathVariable Integer id) {
        return tareaService.deleteTarea(id);
    }
}
