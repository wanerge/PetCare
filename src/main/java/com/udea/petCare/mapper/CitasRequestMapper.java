package com.udea.petCare.mapper;

import com.udea.petCare.dto.CitasRequestDTO;
import com.udea.petCare.entity.*;
import com.udea.petCare.repository.*;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CitasRequestMapper {

    private final ClientesRepository clientesRepo;
    private final MascotasRepository mascotasRepo;
    private final VeterinariosRepository veterinariosRepo;
    private final EstadosRepository estadosRepo;
    private final ServiciosRepository serviciosRepo;

    public CitasRequestMapper(ClientesRepository clientesRepo,
            MascotasRepository mascotasRepo,
            VeterinariosRepository veterinariosRepo,
            EstadosRepository estadosRepo,
            ServiciosRepository serviciosRepo) {
        this.clientesRepo = clientesRepo;
        this.mascotasRepo = mascotasRepo;
        this.veterinariosRepo = veterinariosRepo;
        this.estadosRepo = estadosRepo;
        this.serviciosRepo = serviciosRepo;
    }

    public Citas toEntity(CitasRequestDTO dto) {
        Citas cita = new Citas();
        cita.setFecha_cita(dto.getFecha());
        cita.setHora_cita(dto.getHora());

        Clientes cliente = clientesRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Mascotas mascota = mascotasRepo.findById(dto.getIdMascota())
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        Veterinarios vet = veterinariosRepo.findById(dto.getIdVeterinario())
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));
        Estados estado = estadosRepo.findById(dto.getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        cita.setCliente(cliente);
        cita.setMascota(mascota);
        cita.setVeterinario(vet);
        cita.setEstado(estado);

        // Relación muchos a muchos a través de la tabla intermedia
        List<CitaXServicio> serviciosAsignados = dto.getIdServicios().stream()
                .map(id -> {
                    Servicios servicio = serviciosRepo.findById(id)
                            .orElseThrow(() -> new RuntimeException("Servicio ID " + id + " no encontrado"));
                    return new CitaXServicio(cita, servicio);
                })
                .collect(Collectors.toList());

        cita.setServiciosAsignados(serviciosAsignados);

        return cita;
    }
}
