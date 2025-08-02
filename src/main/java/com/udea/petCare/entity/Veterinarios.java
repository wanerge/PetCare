package com.udea.petCare.entity;

import lombok.*;

import java.io.Serializable;
import jakarta.persistence.*;

@Data
@RequiredArgsConstructor
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
    private String nombre;

    @Column(name = "apellido", length = 50)
    @NonNull
    private String apellido;

    @Column(name = "telefono", length = 10)
    @NonNull
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_usuario", unique = true)
    @NonNull
    private Usuarios usuario;

}
