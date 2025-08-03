package com.udea.petCare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.dto.VeterinariosDTO;
import com.udea.petCare.repository.VeterinariosRepository;

@Service
public interface VeterinariosService {

    @Autowired
    private VeterinariosRepository veterinariosRepository;

    public List<VeterinariosDTO> findAll() {
        List<Veterinarios> all = (List<Veterinarios>) veterinariosRepository.findAll();
        return all.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public VeterinariosDTO save(VeterinariosDTO veterinariosDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public VeterinariosDTO update(Long id, VeterinariosDTO veterinariosDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }

    private VeterinariosDTO convertToDTO(VeterinariosDTO veterinariosDTO) {
        return new VeterinariosDTO(veterinariosDTO);
    }
}
