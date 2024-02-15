package com.dam.pruebaspring.controller;

import com.dam.pruebaspring.models.Tarea;
import com.dam.pruebaspring.servicies.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/save")
    public Tarea saveTarea(@RequestBody Tarea tarea) {
        return tareaService.saveTarea(tarea);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteTarea(@PathVariable Integer id) {
        return tareaService.deleteTarea(id);
    }
}
