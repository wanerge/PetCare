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
    private long idCliente;
    private long idMascota;
    private long idVeterinario;
    private long idEstado;
    private List<Long> idServicios;
}
