package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="tblCitaXServicio")
@Data
@AllArgsConstructor
@NoArgsConstructor 

public class CitaXServicio implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    @NonNull
    private Citas cita;

    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    @NonNull
    private Servicios servicio;

}

