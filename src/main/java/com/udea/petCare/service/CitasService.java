package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.entity.Citas;
import com.udea.petCare.repository.CitasRepository;

@Service
public class CitasService {

    @Autowired
    private CitasRepository citasRepository;

    public List<Citas> listarCitas() {
        return citasRepository.findAll().stream().collect(Collectors.toList());
    }

    public Citas save(Citas citasDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Citas update(Long id,Citas citasDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void delete(Long id) {
        citasRepository.deleteById(id);
    }

    private Citas convertToDTO(Citas cita) {
        return new Citas();
    }

    
}
