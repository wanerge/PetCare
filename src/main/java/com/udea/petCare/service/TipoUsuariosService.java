package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.entity.TipoUsuarios;
import com.udea.petCare.repository.TipoUsuariosRepository;

@Service
public class TipoUsuariosService {

    @Autowired
    private TipoUsuariosRepository tipoUsuariosRepository;
    
    public List<TipoUsuarios> listarTipoUsuarios(){
        return tipoUsuariosRepository.findAll().stream().collect(Collectors.toList());
    }
}
