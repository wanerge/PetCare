package com.udea.petCare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.dto.VeterinariosDTO;

@Service
public class VeterinariosService {
    
    @Autowired
    private VeterinariosRepository veterinariosRepository;

    @Override
    public List<VeterinariosDTO> findAll() {
        List<Veterinarios> all = (List<Veterinarios>) veterinariosRepository.findAll();
        return all.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public VeterinariosDTO save(VeterinariosDTO veterinariosDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public VeterinariosDTO update(int id, VeterinariosDTO alumnoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        alumnoRepository.deleteById(id);
    }

    private VeterinariosDTO convertToDTO(Veterinarios veterinarios) {
        return new VeterinariosDTO(veterinarios);
    }
}
