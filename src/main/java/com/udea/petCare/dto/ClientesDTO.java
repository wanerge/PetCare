package com.udea.petCare.dto;

import java.security.Timestamp;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {

    private long id;
    private String correo;
    private String claveHash;
    private String tokenSesion;
    private Timestamp fechaInicio;
    private long idTipoUsuario;
}
