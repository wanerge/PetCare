package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.dto.ClientesDTO;

import com.udea.petCare.entity.Clientes;
import com.udea.petCare.repository.ClientesRepository;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> listarClientes() {
        return clientesRepository.findAll().stream().collect(Collectors.toList());

    }
    public Clientes save(Clientes clientesDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");    

    }

    public Clientes update(Long id, Clientes usuariosDTO){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void delete(Long id){
        clientesRepository.deleteById(id);
    }

    private ClientesDTO convertToDTO(Clientes clientes) {
        return new ClientesDTO(clientes);

 
    
}   

    }

