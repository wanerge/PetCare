package com.usdea.petCare.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@Table(name = "tblEstados")
public class Estados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_estado")
    private int id_estado;

    @Column(name = "nomobre_estado", length = 15)
    @NonNull
    private String nombre_estado;

}
