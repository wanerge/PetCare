package com.udea.petCare.dto;

import java.util.List;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeterinariosDTO {

    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private List<String> especialidades;
}