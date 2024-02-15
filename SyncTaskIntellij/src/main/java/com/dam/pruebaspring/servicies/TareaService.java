package com.dam.pruebaspring.servicies;

import com.dam.pruebaspring.models.Tarea;
import com.dam.pruebaspring.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    public Tarea getTareaById(Integer id) {
        return tareaRepository.findById(id).get();
    }

    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Boolean deleteTarea(Integer id) {
        tareaRepository.deleteById(id);

        return tareaRepository.findById(id).isEmpty();
    }

}
