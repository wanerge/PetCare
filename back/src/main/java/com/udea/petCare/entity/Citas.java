package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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
    private long idCita;

    @Column(name = "fecha_cita")
    @NonNull
    private LocalDate fechaCita;

    @Column(name = "hora_cita")
    @NonNull
    private LocalTime horaCita;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tblCitasXServicios",
        joinColumns = @JoinColumn(name = "id_cita"),
        inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private List<Servicios> serviciosAsignados;
}