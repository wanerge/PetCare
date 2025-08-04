package com.udea.petCare.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    private long idUsuario;

    @Column(name = "correo", unique = true, length = 50)
    @NonNull
    @NotBlank
    @Email
    private String correo;

    @Column(name = "clave_hash", length = 200)
    @NonNull
    @NotBlank
    private String claveHash;

    @Column(name = "token_sesion", length = 200)
    private String tokenSesion;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_expiracion")
    private LocalDateTime fechaExpiracion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    @NonNull
    private TipoUsuarios tipoUsuario;

    public Usuarios(@NonNull @NotBlank @Email String correo, @NonNull @NotBlank String clave_hash,
            @NonNull TipoUsuarios tipoUsuario) {
        this.correo = correo;
        this.claveHash = clave_hash;
        this.tipoUsuario = tipoUsuario;
    }

}
