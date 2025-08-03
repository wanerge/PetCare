package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblGeneros")
@Entity
public class Generos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private long id_genero;

    @Column(name = "nombre_genero", length = 20)
    @NonNull
    @NotBlank
    private String nombre_genero;
}
