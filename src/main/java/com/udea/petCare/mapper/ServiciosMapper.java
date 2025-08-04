package com.udea.petCare.mapper;

import com.udea.petCare.dto.ServiciosDTO;
import com.udea.petCare.entity.Servicios;

public class ServiciosMapper {

    public static ServiciosDTO toDTO(Servicios servicio) {
        return new ServiciosDTO(
                servicio.getIdServicio(),
                servicio.getNombreServicio(),
                servicio.getDescripcion(),
                servicio.getPrecio());
    }

    public static Servicios toEntity(ServiciosDTO serviciosDTO) {
        Servicios servicio = new Servicios();
        servicio.setIdServicio(serviciosDTO.getId());
        servicio.setNombreServicio(serviciosDTO.getNombre());
        servicio.setDescripcion(serviciosDTO.getDescripcion());
        servicio.setPrecio(serviciosDTO.getPrecio());
        return servicio;
    }

}
