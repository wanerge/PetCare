package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udea.petCare.dto.ServiciosDTO;
import com.udea.petCare.service.ServiciosService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin("*")
public class ServiciosController {

    @Autowired
    private ServiciosService serviciosService;

    @GetMapping
    public List<ServiciosDTO> getMethodName() {
        return serviciosService.findAll();
    }

}
