package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Proyecto;
import com.dam.pruebaspring.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto getProyectoById(Integer id) {
        return proyectoRepository.findById(id).get();
    }

    public Proyecto saveProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Proyecto getProyectoByNombre(String nombre) {
        return proyectoRepository.findByNombre(nombre);
    }


    public Boolean deleteProyecto(Integer id) {
        proyectoRepository.deleteById(id);

        return proyectoRepository.findById(id).isEmpty();
    }

}
