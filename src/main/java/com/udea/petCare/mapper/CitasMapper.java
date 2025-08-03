package com.udea.petCare.mapper;

import com.udea.petCare.dto.*;
import com.udea.petCare.entity.*;
import java.util.stream.Collectors;

public class CitasMapper {

        public static CitasDTO toDTO(Citas cita) {
                return new CitasDTO(
                                cita.getId_cita(),
                                cita.getFecha_cita(),
                                cita.getHora_cita(),
                                cita.getCliente().getNombre(),
                                cita.getMascota().getNombre(),
                                cita.getVeterinario().getNombre(),
                                cita.getEstado().getNombre_estado(),
                                cita.getServiciosAsignados().stream()
                                                .map(cs -> new ServicioSimpleDTO(
                                                                cs.getServicio().getId_servicio(),
                                                                cs.getServicio().getNombre_servicio(),
                                                                cs.getServicio().getDescripcion(),
                                                                cs.getServicio().getPrecio()))
                                                .collect(Collectors.toList()));
        }
}
