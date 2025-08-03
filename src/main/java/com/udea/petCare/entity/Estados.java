package com.udea.petCare.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblEstados")
public class Estados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private long id_estado;

    @Column(name = "nombre_estado", length = 15)
    @NonNull
    @NotBlank
    private String nombre_estado;
}
