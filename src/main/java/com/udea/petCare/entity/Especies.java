package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tblEspecies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especie")
    private long id_especie;

    @Column(name = "nombre_especie", length = 20)
    @NonNull
    @NotBlank
    private String nombre_especie;
}
