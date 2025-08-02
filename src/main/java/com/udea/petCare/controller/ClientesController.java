package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.petCare.entity.Clientes;
import com.udea.petCare.service.ClientesService;




@RestController
@RequestMapping("/api/Clientes")
@CrossOrigin("*")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;


    @GetMapping("/listar")
    public List<Clientes> listarClientes(){
        return clientesService.listarClientes();
    }

    @PostMapping
    public Clientes crearClientes(@RequestBody Clientes clientes) {
        
        return clientesService.save(clientes);
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
