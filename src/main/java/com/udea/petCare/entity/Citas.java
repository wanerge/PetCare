package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;    

import jakarta.persistence.*;


@Entity
@Table(name="tblCitas")
@Data
@AllArgsConstructor
@NoArgsConstructor 
@RequiredArgsConstructor

public class Citas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private long idCita;
    
    
    @Column(name = "fecha_cita", nullable = false)
    @NonNull
    private String fechaCita;

    @Column(name = "hora_cita", nullable = false)
    @NonNull
    private String horaCita;

    @ManyToOne
    @JoinColumn(name = "id_cliente", unique= true)
    @NonNull
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_mascota", unique= true)
    @NonNull
    private Mascotas mascota;

    @ManyToOne
    @JoinColumn(name = "id_veterinario", unique= true)
    @NonNull
    private Veterinarios veterinario;

    @ManyToOne
    @JoinColumn(name = "id_estado", unique= true)
    @NonNull
    private Estados estado;


    
}