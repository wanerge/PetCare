package com.udea.petCare.entity;

import lombok.*;
import jakarta.persistence.*;
import java.security.Timestamp;

@Entity
@Table(name = "tblMascotas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private long id_mascota;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NonNull
    private Clientes cliente;

    @Column(name = "nombre", nullable = false, length = 50)
    @NonNull 
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    @NonNull
    private Especies especie;

    @Column(name = "fecha_nacimiento", nullable = false)
    @NonNull
    private Timestamp fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    @NonNull
    private Generos genero;

    @Column(name = "peso", nullable = false, length = 20)
    @NonNull
    private double peso;
    
}
