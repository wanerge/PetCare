package com.udea.petCare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.repository.CitasRepository;

@Service
public class CitasService {

    @Autowired
    private CitasRepository citasRepository;

    @Override
    public List<CitasDTO> findAll() {
        List<Citas> all = (List<Citas>) citasRepository.findAll();
        return all.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public AlumnoDTO save(CitasDTO citasDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public CitasDTO update(Long id, CitasDTO citasDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        citasRepository.deleteById(id);
    }

    private CitasDTO convertToDTO(Citas cita) {
        return new CitasDTO(cita);
    }
}
