package com.dam.pruebaspring.controller;

import com.dam.pruebaspring.models.Proyecto;
import com.dam.pruebaspring.servicies.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ProyectoControl {
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/all")
    public List<Proyecto> getAllProyectos(){
        return proyectoService.getAllProyectos();
    }
    @GetMapping("/id/{id}")
    public Proyecto getProyectoById(@PathVariable Integer id){
        return proyectoService.getProyectoById(id);
    }

    @PostMapping("/save")
    public Proyecto saveProyecto(@RequestBody Proyecto proyecto){
        return proyectoService.saveProyecto(proyecto);
    }

    @PutMapping("/update")
    public Proyecto updateProyecto(@RequestBody Proyecto proyecto){
        return proyectoService.saveProyecto(proyecto);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProyecto(@PathVariable Integer id){
        return proyectoService.deleteProyecto(id);
    }
}
