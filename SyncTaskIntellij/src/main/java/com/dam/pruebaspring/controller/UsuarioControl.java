package com.dam.pruebaspring.controller;

import com.dam.pruebaspring.models.Usuario;
import com.dam.pruebaspring.servicies.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControl {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/nombre/{nombre}")
    public Usuario getUsuarioByNombre(@PathVariable String nombre) {return usuarioService.getUsuarioByNombre(nombre);}

    @GetMapping("/email/{email}")
    public Usuario getUsuarioByEmail(@PathVariable String email) {return usuarioService.getUsuarioByEmail(email);}


    @GetMapping("/all")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/id/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping("/save")
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/update")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteUsuario(@PathVariable Integer id) {
        return usuarioService.deleteUsuario(id);
    }
}
