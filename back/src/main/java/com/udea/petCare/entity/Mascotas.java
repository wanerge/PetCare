package com.udea.petCare.entity;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblMascotas")
public class Mascotas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private long idMascota;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NonNull
    private Clientes cliente;

    @Column(name = "nombre", length = 50)
    @NonNull
    @NotBlank
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    @NonNull
    private Especies especie;

    @Column(name = "fecha_nacimiento")
    @NonNull
    private LocalDateTime fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    @NonNull
    private Generos genero;

    @Column(name = "peso", precision = 20, scale = 2)
    @NonNull
    private BigDecimal peso;
}
