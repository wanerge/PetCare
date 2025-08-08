package com.udea.petCare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesRequestDTO {

    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;
    private String clave;

}
