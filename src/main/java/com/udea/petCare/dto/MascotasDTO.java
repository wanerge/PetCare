package com.udea.petCare.dto;

import java.security.Timestamp;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotasDTO {

    private Long id_mascota;
    private String nombre;
    private Long id_especie;
    private Timestamp fecha_nacimiento;
    private Long id_genero;
    private double peso;
}
