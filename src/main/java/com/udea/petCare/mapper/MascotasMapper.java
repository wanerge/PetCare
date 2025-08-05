package com.udea.petCare.mapper;

import com.udea.petCare.dto.MascotasDTO;
import com.udea.petCare.entity.Mascotas;

public class MascotasMapper {

    public static MascotasDTO toDTO(Mascotas mascotas) {
        if (mascotas == null) {
            return null;
        }
        MascotasDTO dto = new MascotasDTO();
        dto.setIdMascota(mascotas.getIdMascota());
        dto.setIdCliente(mascotas.getCliente().getIdCliente());
        dto.setNombre(mascotas.getNombre());
        dto.setEspecie(mascotas.getEspecie().getNombreEspecie());
        dto.setFechaNacimiento(mascotas.getFechaNacimiento());
        dto.setGenero(mascotas.getGenero().getNombreGenero());
        dto.setPeso(mascotas.getPeso()); 
        return dto;
    }
}
