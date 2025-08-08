package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udea.petCare.dto.MascotasDTO;
import com.udea.petCare.dto.MascotasRequestDTO;
import com.udea.petCare.service.MascotasService;

@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin("*")
public class MascotasController {

    @Autowired
    private MascotasService mascotasService;

    @GetMapping
    public List<MascotasDTO> findAll() {
        return mascotasService.findAll();
    }

    @GetMapping("/{id}")
    public MascotasDTO findById(@PathVariable Long id) {
        return mascotasService.findById(id);
    }

    @PostMapping
    public MascotasDTO save(@RequestBody MascotasRequestDTO dto) {
        return mascotasService.save(dto);
    }

    @GetMapping("/clientes/{clienteId}")
    public List<MascotasDTO> findByIdCliente(@PathVariable Long clienteId) {
        return mascotasService.findByIdCliente(clienteId);
    }

    @GetMapping("/clientes")
    public List<MascotasDTO> findMascotas() {
        return mascotasService.findMascotas();
    }

}
