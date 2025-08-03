package com.udea.petCare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblServicios")
public class Servicios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private long id_servicio;

    @Column(name = "nombre_servicio", length = 50)
    @NonNull
    @NotBlank
    private String nombre_servicio;

    @Column(name = "descripcion")
    @NonNull
    @NotBlank
    private String descripcion;

    @Column(name = "precio", precision = 20, scale = 2)
    @NonNull
    @NotBlank
    private BigDecimal precio;
}
