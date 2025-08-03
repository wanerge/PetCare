package com.udea.petCare.entity;

import java.io.Serializable;
import java.security.Timestamp;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblUsuarios")
public class Usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id_usuario;

    @Column(name = "correo", unique = true, length = 50)
    @NonNull
    @NotBlank
    @Email
    private String correo;

    @Column(name = "clave_hash", length = 200)
    @NonNull
    @NotBlank
    private String clave_hash;

    @Column(name = "token_sesion", length = 200)
    private String token_sesion;

    @Column(name = "fecha_inicio")
    private Timestamp fecha_inicio;

    @Column(name = "fecha_expiracion")
    private Timestamp fecha_expiracion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    @NonNull
    private TipoUsuarios tipoUsuario;
}
