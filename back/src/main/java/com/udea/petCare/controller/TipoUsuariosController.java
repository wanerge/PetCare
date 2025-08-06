package com.udea.petCare.controller;

import org.springframework.web.bind.annotation.RestController;

import com.udea.petCare.entity.TipoUsuarios;
import com.udea.petCare.service.TipoUsuariosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/tipoUsuarios")
@CrossOrigin("*")
public class TipoUsuariosController {

    @Autowired
    private TipoUsuariosService tipoUsuariosService;

    @GetMapping("/listar")
    public List<TipoUsuarios> listarTipoUsuarios() {
        return tipoUsuariosService.listarTipoUsuarios();
    }

}
