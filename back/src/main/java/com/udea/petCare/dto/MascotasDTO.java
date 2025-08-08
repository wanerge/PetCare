package com.udea.petCare.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotasDTO {

    private Long idMascota;
    private Long idCliente;
    private String nombre;
    private String especie;
    private LocalDateTime fechaNacimiento;
    private String genero;
    private BigDecimal peso;
}
