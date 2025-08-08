package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.udea.petCare.dto.CitasDTO;
import com.udea.petCare.dto.CitasRequestDTO;
import com.udea.petCare.entity.Citas;
import com.udea.petCare.entity.Clientes;
import com.udea.petCare.entity.Estados;
import com.udea.petCare.entity.Mascotas;
import com.udea.petCare.entity.Servicios;
import com.udea.petCare.entity.Veterinarios;
import com.udea.petCare.mapper.CitasMapper;
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

        public List<CitasDTO> findAll() {
                return citasRepository.findAll().stream().map(CitasMapper::toDTO).collect(Collectors.toList());
        }

        public List<CitasDTO> findByVeterinarioId(Long veterinarioId) {
                return citasRepository.findByVeterinarioIdVeterinario(veterinarioId).stream()
                                .map(CitasMapper::toDTO)
                                .collect(Collectors.toList());
        }

        public List<CitasDTO> findByVeterinarioIdAndEstado() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                Long idUsuario = Long.parseLong(authentication.getName());
                Long veterinarioId = veterinariosRepository.findByUsuarioIdUsuario(idUsuario)
                                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"))
                                .getIdVeterinario();

                return citasRepository.findByVeterinarioIdVeterinarioAndEstado(veterinarioId, "estado").stream()
                                .map(CitasMapper::toDTO)
                                .collect(Collectors.toList());
        }

        public CitasDTO save(CitasRequestDTO citasRequestDTO) {
                Clientes cliente = clientesRepository.findById(citasRequestDTO.getIdCliente())
                                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

                Mascotas mascota = mascotasRepository.findById(citasRequestDTO.getIdMascota())
                                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

                Veterinarios veterinario = veterinariosRepository.findById(citasRequestDTO.getIdVeterinario())
                                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));

                Estados estado = estadosRepository.findById(citasRequestDTO.getIdEstado())
                                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

                List<Servicios> serviciosAsignados = citasRequestDTO.getIdServicios().stream()
                                .map(idServicio -> serviciosRepo.findById(idServicio)
                                                .orElseThrow(() -> new RuntimeException(
                                                                "Servicio ID " + idServicio + " no encontrado")))
                                .collect(Collectors.toList());

                Citas citas = new Citas();
                citas.setFechaCita(citasRequestDTO.getFecha());
                citas.setHoraCita(citasRequestDTO.getHora());
                citas.setCliente(cliente);
                citas.setMascota(mascota);
                citas.setVeterinario(veterinario);
                citas.setEstado(estado);
                citas.setServiciosAsignados(serviciosAsignados);
                citasRepository.save(citas);
                return CitasMapper.toDTO(citas);
        }

        public CitasDTO update(Long id, CitasRequestDTO citasRequestDTO) {
                Citas existingCita = citasRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));

                Mascotas mascota = mascotasRepository.findById(citasRequestDTO.getIdMascota())
                                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

                Veterinarios veterinario = veterinariosRepository.findById(citasRequestDTO.getIdVeterinario())
                                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado"));

                Estados estado = estadosRepository.findById(citasRequestDTO.getIdEstado())
                                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

                List<Servicios> serviciosAsignados = citasRequestDTO.getIdServicios().stream()
                                .map(idServicio -> serviciosRepo.findById(idServicio)
                                                .orElseThrow(() -> new RuntimeException(
                                                                "Servicio ID " + idServicio + " no encontrado")))
                                .collect(Collectors.toList());

                existingCita.setFechaCita(citasRequestDTO.getFecha());
                existingCita.setHoraCita(citasRequestDTO.getHora());
                existingCita.setMascota(mascota);
                existingCita.setVeterinario(veterinario);
                existingCita.setEstado(estado);
                existingCita.setServiciosAsignados(serviciosAsignados);
                citasRepository.save(existingCita);

                return CitasMapper.toDTO(existingCita);
        }

        public String delete(Long id) {
                if (!citasRepository.existsById(id)) {
                        throw new RuntimeException("Cita no encontrada");
                }
                citasRepository.deleteById(id);
                return "Cita eliminada exitosamente";
        }

        public CitasDTO findById(Long id) {
                return citasRepository.findById(id)
                                .map(CitasMapper::toDTO)
                                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));
        }

        public List<CitasDTO> findByClienteId(Long clienteId) {
                return citasRepository.findByClienteIdCliente(clienteId).stream()
                                .map(CitasMapper::toDTO)
                                .collect(Collectors.toList());
        }
}
