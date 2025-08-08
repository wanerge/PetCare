package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.udea.petCare.dto.VeterinariosDTO;
import com.udea.petCare.dto.VeterinariosRequestDTO;
import com.udea.petCare.entity.Especialidades;
import com.udea.petCare.entity.TipoUsuarios;
import com.udea.petCare.entity.Usuarios;
import com.udea.petCare.entity.Veterinarios;
import com.udea.petCare.mapper.VeterinariosMapper;
import com.udea.petCare.repository.EspecialidadesRepository;
import com.udea.petCare.repository.TipoUsuariosRepository;
import com.udea.petCare.repository.UsuariosRepository;
import com.udea.petCare.repository.VeterinariosRepository;

@Service
public class VeterinariosService {

        @Autowired
        private VeterinariosRepository veterinariosRepository;

        @Autowired
        private UsuariosRepository usuariosRepository;

        @Autowired
        private TipoUsuariosRepository tipoUsuariosRepository;

        @Autowired
        private EspecialidadesRepository especialidadesRepo;

        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        public VeterinariosDTO findById(Long id) {
                return veterinariosRepository.findById(id)
                                .map(VeterinariosMapper::toDTO)
                                .orElse(null);
        }

        public List<VeterinariosDTO> findAll() {
                return veterinariosRepository.findAll().stream()
                                .map(VeterinariosMapper::toDTO)
                                .collect(Collectors.toList());
        }

        public VeterinariosDTO save(VeterinariosRequestDTO dto) {
                if (usuariosRepository.findByCorreo(dto.getCorreo()).isPresent()) {
                        throw new RuntimeException("El correo ya está registrado");
                }

                TipoUsuarios tipoUsuario = tipoUsuariosRepository.findByTipoUsuario("Veterinario")
                                .orElseThrow(() -> new RuntimeException("Tipo de usuario no encontrado"));

                List<Especialidades> especialidadesAsignadas = dto.getEspecialidadesIds().stream()
                                .map(id -> especialidadesRepo.findById(id)
                                                .orElseThrow(() -> new RuntimeException(
                                                                "Especialidad no encontrada con ID: " + id)))
                                .collect(Collectors.toList());

                Veterinarios veterinario = new Veterinarios();
                veterinario.setNombre(dto.getNombre());
                veterinario.setApellido(dto.getApellido());
                veterinario.setTelefono(dto.getTelefono());
                veterinario.setUsuario(usuariosRepository.save(
                                new Usuarios(dto.getCorreo(), passwordEncoder.encode(dto.getClave()), tipoUsuario)));
                veterinario.setEspecialidades(especialidadesAsignadas);
                veterinariosRepository.save(veterinario);
                return VeterinariosMapper.toDTO(veterinario);
        }
}