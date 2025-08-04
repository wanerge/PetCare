package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.petCare.dto.CitasRequestDTO;
import com.udea.petCare.entity.CitaXServicio;
import com.udea.petCare.entity.Citas;
import com.udea.petCare.entity.Clientes;
import com.udea.petCare.entity.Estados;
import com.udea.petCare.entity.Mascotas;
import com.udea.petCare.entity.Servicios;
import com.udea.petCare.entity.Veterinarios;
import com.udea.petCare.repository.CitasRepository;
import com.udea.petCare.repository.ClientesRepository;
import com.udea.petCare.repository.EstadosRepository;
import com.udea.petCare.repository.MascotasRepository;
import com.udea.petCare.repository.ServiciosRepository;
import com.udea.petCare.repository.VeterinariosRepository;

@Service
public class CitasService {

        @Autowired
        private CitasRepository citasRepository;

        @Autowired
        private ClientesRepository clientesRepository;

        @Autowired
        private MascotasRepository mascotasRepository;

        @Autowired
        private VeterinariosRepository veterinariosRepository;

        @Autowired
        private EstadosRepository estadosRepository;

        @Autowired
        private ServiciosRepository serviciosRepo;

        public List<Citas> findAll() {
                return citasRepository.findAll().stream().collect(Collectors.toList());
        }

        public Citas save(CitasRequestDTO citasRequestDTO) {
                Clientes cliente = clientesRepository.findById(citasRequestDTO.getIdCliente())
                                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

                Mascotas mascota = mascotasRepository.findById(citasRequestDTO.getIdMascota())
                                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

                Veterinarios veterinario = veterinariosRepository.findById(citasRequestDTO.getIdVeterinario())
                                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));

                Estados estado = estadosRepository.findById(citasRequestDTO.getIdEstado())
                                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

                Citas citas = new Citas();
                citas.setFecha_cita(citasRequestDTO.getFecha());
                citas.setHora_cita(citasRequestDTO.getHora());
                citas.setCliente(cliente);
                citas.setMascota(mascota);
                citas.setVeterinario(veterinario);
                citas.setEstado(estado);

                List<CitaXServicio> serviciosAsignados = citasRequestDTO.getIdServicios().stream()
                                .map(id -> {
                                        Servicios servicio = serviciosRepo.findById(id)
                                                        .orElseThrow(() -> new RuntimeException(
                                                                        "Servicio ID " + id + " no encontrado"));
                                        return new CitaXServicio(citas, servicio);
                                })
                                .collect(Collectors.toList());

                citas.setServiciosAsignados(serviciosAsignados);

                return citasRepository.save(citas);
        }

        public Citas update(Long id, CitasRequestDTO citasRequestDTO) {
                Citas existingCita = citasRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));

                Mascotas mascota = mascotasRepository.findById(citasRequestDTO.getIdMascota())
                                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

                Veterinarios veterinario = veterinariosRepository.findById(citasRequestDTO.getIdVeterinario())
                                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));

                Estados estado = estadosRepository.findById(citasRequestDTO.getIdEstado())
                                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

                existingCita.setFecha_cita(citasRequestDTO.getFecha());
                existingCita.setHora_cita(citasRequestDTO.getHora());
                existingCita.setMascota(mascota);
                existingCita.setVeterinario(veterinario);
                existingCita.setEstado(estado);

                List<CitaXServicio> serviciosAsignados = citasRequestDTO.getIdServicios().stream()
                                .map(idServicio -> {
                                        Servicios servicio = serviciosRepo.findById(idServicio)
                                                        .orElseThrow(() -> new RuntimeException(
                                                                        "Servicio ID " + idServicio
                                                                                        + " no encontrado"));
                                        return new CitaXServicio(existingCita, servicio);
                                })
                                .collect(Collectors.toList());

                existingCita.setServiciosAsignados(serviciosAsignados);

                return citasRepository.save(existingCita);
        }

        public void delete(Long id) {
                if (!citasRepository.existsById(id)) {
                        throw new RuntimeException("Cita no encontrada");
                }
                citasRepository.deleteById(id);
        }

        public Citas findById(Long id) {
                return citasRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));
        }

        public List<Citas> findByClienteId(Long clienteId) {
                return citasRepository.findByClienteId(clienteId).stream().collect(Collectors.toList());
        }
}
