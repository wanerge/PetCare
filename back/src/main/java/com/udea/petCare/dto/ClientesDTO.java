package com.udea.petCare.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {

    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
}
