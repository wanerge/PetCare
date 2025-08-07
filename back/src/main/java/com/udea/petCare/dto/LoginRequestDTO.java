package com.udea.petCare.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

     private String correo;
     private String clave;
}
