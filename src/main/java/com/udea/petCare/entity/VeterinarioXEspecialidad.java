package com.udea.petCare.entity;

import java.io.Serializable;
import jakarta.persistence.*;

import lombok.*;    

@Entity
@Table(name="tblVeterinarioXEspecialidad")
@Data
@AllArgsConstructor
@NoArgsConstructor 

class VeterinarioXEspecialidad implements Serializable {

     @ManyToOne
    @JoinColumn(name = "id_veterinario", nullable = false)
    @NonNull
    private Veterinarios veterinario;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    @NonNull
    private Especialidades especialidad;

    
}