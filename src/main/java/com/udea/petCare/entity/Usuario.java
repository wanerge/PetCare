package com.udea.petCare.entity;

import java.security.Timestamp;
import lombok.*;
import jakarta.persistence.*;
@Entity
@Table(name="tblUsuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id;

    @Column(name ="correo", unique = true)
    @NonNull
    private String correo;

    @Column(name = "clave_hash")
    @NonNull
    private String claveHash;

    @Column(name= "token_sesion")
    private String tokenSesion;

    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    @NonNull
    private int idTipoUsuario;

   
    
}
