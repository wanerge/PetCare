package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udea.petCare.dto.VeterinariosDTO;
import com.udea.petCare.dto.VeterinariosRequestDTO;
import com.udea.petCare.service.VeterinariosService;

@RestController
@RequestMapping("/api/veterinarios")
@CrossOrigin("*")
public class VeterinariosController {

    @Autowired
    private VeterinariosService veterinariosService;

    @GetMapping
    public List<VeterinariosDTO> findAll() {
        return veterinariosService.findAll();
    }

    @PostMapping
    public VeterinariosDTO save(@RequestBody VeterinariosRequestDTO dto) {
        return veterinariosService.save(dto);
    }

}
