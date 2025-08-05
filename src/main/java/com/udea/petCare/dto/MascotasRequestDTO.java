package com.udea.petCare.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotasRequestDTO {

    private Long idMascota;
    private long idCliente;
    private String nombre;
    private long idEspecie;
    private LocalDateTime fechaNacimiento;
    private long idGenero;
    private BigDecimal peso;

}
