package com.udea.petCare.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblServicios")
public class Servicios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    int id_servicio;

    @Column(name = "nombre", nullable = false, length = 30)
    @NonNull
    String nombre;

    @Column(name = "descripcion", nullable = false)
    @NonNull
    String descripcion;

    @Column(name = "precio", nullable = false, length = 20)
    @NonNull
    float precio;

}
