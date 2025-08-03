package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblCitas")
public class Citas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private long id_cita;

    @Column(name = "fecha_cita")
    @NonNull
    private LocalDate fecha_cita;

    @Column(name = "hora_cita")
    @NonNull
    private LocalTime hora_cita;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NonNull
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_mascota")
    @NonNull
    private Mascotas mascota;

    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    @NonNull
    private Veterinarios veterinario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    @NonNull
    private Estados estado;

    @OneToMany(mappedBy = "cita", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CitaXServicio> serviciosAsignados;
}