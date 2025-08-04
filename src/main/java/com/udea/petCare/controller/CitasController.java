package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.petCare.dto.CitasRequestDTO;
import com.udea.petCare.entity.Citas;
import com.udea.petCare.service.CitasService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitasController {

    @Autowired
    private CitasService citasService;

    @GetMapping("/citas")
    public List<Citas> findAll() {
        return citasService.findAll();
    }

    @GetMapping("/{id}")
    public Citas findById(@PathVariable Long id) {
        return citasService.findById(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Citas> findByClienteId(@PathVariable Long clienteId) {
        return citasService.findByClienteId(clienteId);
    }

    @PostMapping
    public Citas save(@RequestBody CitasRequestDTO citasRequestDTO) {
        return citasService.save(citasRequestDTO);
    }

    @PutMapping("/{id}")
    public Citas update(@PathVariable Long id, @RequestBody CitasRequestDTO citasRequestDTO) {
        return citasService.update(id, citasRequestDTO);
    }

    @GetMapping("/{id}")
    public void delete(@PathVariable Long id) {
        citasService.delete(id);
    }
}