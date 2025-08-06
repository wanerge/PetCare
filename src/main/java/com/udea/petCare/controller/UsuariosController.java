package com.udea.petCare.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udea.petCare.dto.LoginRequestDTO;
import com.udea.petCare.service.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/iniciarSesion")
    public void iniciarSesion(@RequestBody LoginRequestDTO loginRequestDTO) {
        usuariosService.login(loginRequestDTO);
    }
}
