package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udea.petCare.entity.Citas;
import com.udea.petCare.entity.TipoUsuarios;
import com.udea.petCare.service.CitasService;

@RestController
public class CitasController {

     @Autowired
    private CitasService citasService;

    @GetMapping("/listar")
    public List<Citas> listarCitas() {
        return citasService.listarCitas();
    }

    @PostMapping
    public CitaDTO createCita(@RequestBody CitasDTO citaDTO) {
        return citasService.save(citaDTO);
    }

    @PutMapping("/{id}")
    public CitaDTO updateCita(@PathVariable Long id, @RequestBody CitasDTO citaDTO) {
        return citasService.update(id, citaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable Long id) {
        citasService.delete(id);
    }
}