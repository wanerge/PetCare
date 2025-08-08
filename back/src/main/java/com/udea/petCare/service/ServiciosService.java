package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.dto.ServiciosDTO;
import com.udea.petCare.mapper.ServiciosMapper;
import com.udea.petCare.repository.ServiciosRepository;

@Service
public class ServiciosService {

    @Autowired
    private ServiciosRepository serviciosRepository;

    public List<ServiciosDTO> findAll() {
        return serviciosRepository.findAll().stream().map(ServiciosMapper::toDTO)
                .collect(Collectors.toList());
    }

}
