package com.udea.petCare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblServicios")
public class Servicios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private long idServicio;

    @Column(name = "nombre_servicio", length = 50)
    @NonNull
    @NotBlank
    private String nombreServicio;

    @Column(name = "descripcion")
    @NonNull
    @NotBlank
    private String descripcion;

    @Column(name = "precio", precision = 20, scale = 2)
    @NonNull
    private BigDecimal precio;

    @ManyToMany(mappedBy = "serviciosAsignados", fetch = FetchType.LAZY)
    private List<Citas> citas;
}
