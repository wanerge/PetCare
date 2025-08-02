package com.udea.petCare.entity;

import lombok.*;

import java.io.Serializable;

import jakarta.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblGenero")
@Entity

public class Generos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private long id_genero;


    @Column(name = "nombre_genero", length = 20)
    @NonNull
    private String nombre_genero;
    
}

