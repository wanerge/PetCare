package com.udea.petCare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.petCare.entity.Usuarios;

import com.udea.petCare.service.UsuariosService;


@RestController
@RequestMapping("/api/Clientes")
@CrossOrigin("*")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;


    @GetMapping("/listar")
    public List<Usuarios> listarUsuarios(){
        return usuariosService.listarUsuarios();
    }

    @PostMapping
    public Usuarios crearClientes(@RequestBody Usuarios usuarios) {
        
        return usuariosService.save(usuarios);
    }

    @PutMapping("/{id}")
    public Clientes updateClientes(@PathVariable Long id, @RequestBody Clientes clientes){
        return clientesService.update(id, clientes);
    }
    

    @DeleteMapping("/{id}")
    public void deleteClientes(@PathVariable Long id){
        clientesService.delete(id);
    }
    


    
}
