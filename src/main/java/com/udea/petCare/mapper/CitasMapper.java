package com.udea.petCare.mapper;

import com.udea.petCare.dto.*;
import com.udea.petCare.entity.*;
import java.util.stream.Collectors;

public class CitasMapper {

        public static CitasDTO toDTO(Citas cita) {
                return new CitasDTO(
                                cita.getIdCita(),
                                cita.getFechaCita(),
                                cita.getHoraCita(),
                                cita.getCliente().getNombre(),
                                cita.getMascota().getNombre(),
                                cita.getVeterinario().getNombre(),
                                cita.getEstado().getNombreEstado(),
                                cita.getServiciosAsignados().stream()
                                                .map(ServiciosMapper::toDTO)
                                                .collect(Collectors.toList()));
        }

}
