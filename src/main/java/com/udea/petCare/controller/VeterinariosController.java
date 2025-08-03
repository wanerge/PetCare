package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.petCare.dto.VeterinariosDTO;
import com.udea.petCare.service.VeterinariosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/veterinarios")
@CrossOrigin("*")
public class VeterinariosController {
    
    @Autowired
    private VeterinariosService veterinariosService;

    @GetMapping("/listar")
    public List<VeterinariosDTO> findAll() {
        return veterinariosService.findAll();
    }
    
    @PostMapping()
    public VeterinariosDTO save(@RequestBody VeterinariosDTO veterinariosDTO) {
        
        return veterinariosService.save(veterinariosDTO);
    }
    
    @PutMapping("/{id}")
    public VeterinariosDTO update(@PathVariable Long id, @RequestBody VeterinariosDTO veterinariosDTO) {
        //TODO: process PUT request
        
        return veterinariosService.update(id, veterinariosDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        veterinariosService.delete(id);
    }

}
