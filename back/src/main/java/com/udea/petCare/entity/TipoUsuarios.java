package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;

import jakarta.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblTipoUsuarios")
@Entity
public class TipoUsuarios implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private long id_tipo_usuario;

    @Column(name = "tipo_usuario", nullable = false, length = 20)
    @NonNull
    private String tipo_usuario;
}
