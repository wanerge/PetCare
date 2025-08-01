package com.udea.petCare.entity;

@Entity
@Table(name="tblClientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long idCliente;
    
    
    @Column(name = "nombre")
    @NonNull
    private String nombre;

    @Column(name = "apellido")
    @NonNull
    private String apellido;

    @Column(name = "telefono")
    @NonNull
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique= true)
    @NonNull
    private Usuario usuario;


}
