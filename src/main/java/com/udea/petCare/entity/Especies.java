package com.udea.petCare.entity;

import lombok.*;

import jakarta.persistence.*;
@Entity
@Table(name="tblEspecies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Especies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_especie")
    private long id;

    @Column(name="nombre_especies")
    @NonNull
    private String nombreEspecies;

}
