package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import com.udea.petCare.dto.MascotasDTO;
import com.udea.petCare.dto.MascotasRequestDTO;
import com.udea.petCare.entity.Clientes;
import com.udea.petCare.entity.Especies;
import com.udea.petCare.entity.Generos;
import com.udea.petCare.entity.Mascotas;
import com.udea.petCare.entity.Usuarios;
import com.udea.petCare.mapper.MascotasMapper;
import com.udea.petCare.repository.ClientesRepository;
import com.udea.petCare.repository.EspeciesRepository;
import com.udea.petCare.repository.GenerosRepository;
import com.udea.petCare.repository.MascotasRepository;

@Service
public class MascotasService {

        @Autowired
        private MascotasRepository mascotasRepository;

        @Autowired
        private EspeciesRepository especiesRepository;

        @Autowired
        private GenerosRepository generosRepository;

        @Autowired
        private ClientesRepository clientesRepository;

        public List<MascotasDTO> findAll() {
                return mascotasRepository.findAll().stream()
                                .map(MascotasMapper::toDTO)
                                .collect(Collectors.toList());
        }

        public MascotasDTO findById(Long id) {
                return mascotasRepository.findById(id)
                                .map(MascotasMapper::toDTO)
                                .orElse(null);
        }

        public MascotasDTO save(MascotasRequestDTO dto) {
                Clientes cliente = clientesRepository.findById(dto.getIdCliente())
                                .orElseThrow(() -> new RuntimeException(
                                                "Cliente no encontrado con ID: " + dto.getIdCliente()));

                Especies especie = especiesRepository.findById(dto.getIdEspecie())
                                .orElseThrow(() -> new RuntimeException(
                                                "Especie no encontrada con ID: " + dto.getIdEspecie()));

                Generos genero = generosRepository.findById(dto.getIdGenero())
                                .orElseThrow(() -> new RuntimeException(
                                                "Género no encontrado con ID: " + dto.getIdGenero()));

                Mascotas mascotas = new Mascotas();
                mascotas.setCliente(cliente);
                mascotas.setNombre(dto.getNombre());
                mascotas.setEspecie(especie);
                mascotas.setFechaNacimiento(dto.getFechaNacimiento());
                mascotas.setGenero(genero);
                mascotas.setPeso(dto.getPeso());
                mascotasRepository.save(mascotas);

                return MascotasMapper.toDTO(mascotas);
        }

        public List<MascotasDTO> findByIdCliente(Long idCliente) {
                return mascotasRepository.findByClienteIdCliente(idCliente).stream()
                                .map(MascotasMapper::toDTO)
                                .collect(Collectors.toList());
        }

        public List<MascotasDTO> findMascotas() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                Long idUsuario = Long.parseLong(authentication.getName());

                Long idCliente = clientesRepository.findByUsuarioIdUsuario(idUsuario)
                                .orElseThrow(() -> new RuntimeException(
                                                "Cliente no encontrado para el usuario con ID: " + idUsuario))
                                .getIdCliente();

                return mascotasRepository.findByClienteIdCliente(idCliente).stream()
                                .map(MascotasMapper::toDTO)
                                .collect(Collectors.toList());
        }
}
