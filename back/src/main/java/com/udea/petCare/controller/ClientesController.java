package com.udea.petCare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udea.petCare.dto.ClientesDTO;
import com.udea.petCare.dto.ClientesRequestDTO;
import com.udea.petCare.service.ClientesService;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin("*")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/all")
    public List<ClientesDTO> findAll() {
        return clientesService.findAll();
    }

    @PostMapping("/save")
    public ClientesDTO save(@RequestBody ClientesRequestDTO dto) {
        return clientesService.save(dto);
    }

}
