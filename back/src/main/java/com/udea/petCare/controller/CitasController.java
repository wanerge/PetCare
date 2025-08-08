package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udea.petCare.dto.CitasDTO;
import com.udea.petCare.dto.CitasRequestDTO;
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

    @GetMapping
    public List<CitasDTO> findAll() {
        return citasService.findAll();
    }

    @GetMapping("/{id}")
    public CitasDTO findById(@PathVariable Long id) {
        return citasService.findById(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<CitasDTO> findByClienteId(@PathVariable Long clienteId) {
        return citasService.findByClienteId(clienteId);
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public List<CitasDTO> findByVeterinarioId(@PathVariable Long veterinarioId) {
        return citasService.findByVeterinarioId(veterinarioId);
    }

    @GetMapping("/veterinario/pendientes")
    public List<CitasDTO> findByVeterinarioIdAndEstado() {
        return citasService.findByVeterinarioIdVeterinarioAndEstadoNot();
    }

    @GetMapping("/veterinario/completadas")
    public List<CitasDTO> findByVeterinarioIdAndEstadoNot() {
        return citasService.findByVeterinarioIdVeterinarioAndEstado();
    }

    @PostMapping
    public CitasDTO save(@RequestBody CitasRequestDTO citasRequestDTO) {
        return citasService.save(citasRequestDTO);
    }

    @PutMapping("/{id}")
    public CitasDTO update(@PathVariable Long id, @RequestBody CitasRequestDTO citasRequestDTO) {
        return citasService.update(id, citasRequestDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return citasService.delete(id);
    }
}