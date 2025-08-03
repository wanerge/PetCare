package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblVeterinarios")
@Entity
public class Veterinarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinario")
    private long id_veterinario;

    @Column(name = "nombre", length = 50)
    @NonNull
    @NotBlank
    private String nombre;

    @Column(name = "apellido", length = 50)
    @NonNull
    @NotBlank
    private String apellido;

    @Column(name = "telefono", length = 10)
    @NonNull
    @NotBlank
    private String telefono;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    @NonNull
    private Usuarios usuario;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<VeterinarioXEspecialidad> especialidadesAsignadas;
}
