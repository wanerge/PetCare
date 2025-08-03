package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblEspecialidades")
public class Especialidades implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private long id_especialidad;

    @Column(name = "nombre_especialidad", length = 30)
    @NonNull
    @NotBlank
    private String nombre_especialidad;

    @OneToMany(mappedBy = "especialidad")
    private List<VeterinarioXEspecialidad> veterinariosAsignados;

}
