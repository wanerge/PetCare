package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.dto.UsuariosDTO;
import com.udea.petCare.entity.Usuarios;
import com.udea.petCare.repository.UsuariosRepository;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;


    public List<Usuarios> listarUsuarios() {
        return usuariosRepository.findAll().stream().collect(Collectors.toList());

    }
    public Usuarios save(Usuarios usuariosDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");    

    }

    public Usuarios update(Long id, Usuarios usuariosDTO){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void delete(Long id){
        usuariosRepository.deleteById(id);
    }

    private UsuariosDTO convertToDTO(Usuarios usuarios) {
        return new UsuariosDTO(usuarios);

    
}
}
