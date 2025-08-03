package com.udea.petCare.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeterinariosRequestDTO {

    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String clave;
    private List<Long> especialidadesIds;
}
