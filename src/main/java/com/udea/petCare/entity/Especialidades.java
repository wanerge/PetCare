package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;

import jakarta.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblEspecialidad")

public class Especialidades implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private long id_especialidad;


    @Column(name = "nombre_especialidad", length = 30)
    @NonNull
    private String nombre_especialidad;
    
}
