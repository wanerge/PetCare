package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblTipoUsuarios")
@Entity
public class TipoUsuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private long idTipoUsuario;

    @Column(name = "tipo_usuario", length = 20)
    @NonNull
    @NotBlank
    private String tipoUsuario;
}
