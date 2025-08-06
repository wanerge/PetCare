package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udea.petCare.entity.Servicios;
import com.udea.petCare.repository.ServiciosRepository;

@Service
public class ServiciosService {

    @Autowired
    private ServiciosRepository serviciosRepository;

    public List<Servicios> findAll() {
        return serviciosRepository.findAll().stream().collect(Collectors.toList());
    }

}
