package com.udea.petCare.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblVeterinarioXEspecialidad")
public class VeterinarioXEspecialidad implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    @JsonBackReference
    @NonNull
    private Veterinarios veterinario;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    @NonNull
    private Especialidades especialidad;
}