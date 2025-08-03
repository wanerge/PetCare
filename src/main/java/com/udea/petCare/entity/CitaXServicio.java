package com.udea.petCare.entity;

import lombok.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblCitaXServicio")
public class CitaXServicio implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_cita")
    @JsonBackReference
    @NonNull
    private Citas cita;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    @NonNull
    private Servicios servicio;
}
