package com.udea.petCare.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitasDTO {
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private String clienteNombre;
    private String mascotaNombre;
    private String veterinarioNombre;
    private String estado;
    private List<ServiciosDTO> servicios;
}
