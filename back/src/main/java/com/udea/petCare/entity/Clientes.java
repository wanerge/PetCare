package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblClientes")
public class Clientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;

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

    @Column(name = "direccion", length = 50)
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    @NonNull
    private Usuarios usuario;
}
