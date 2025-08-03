package com.udea.petCare.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitasRequestDTO {
    private LocalDate fecha;
    private LocalTime hora;
    private Long idCliente;
    private Long idMascota;
    private Long idVeterinario;
    private Long idEstado;
    private List<Long> idServicios; // IDs de servicios a asociar
}
