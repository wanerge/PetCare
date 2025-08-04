package com.udea.petCare.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiciosDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
}
