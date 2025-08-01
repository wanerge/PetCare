package com.udea.petCare.dto;

import java.security.Timestamp;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitasDTO {

    private long id;

    private long id_cliente;

    private long id_mascota;

    private long id_veterinario;

    private Timestamp fecha_cita;

    private Timestamp hora_cita;

    private long id_estado;
}