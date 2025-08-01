package com.udea.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeterinariosDTO {

    private long id;

    private String nombre;

    private String apellido;

    private String correo;
}
