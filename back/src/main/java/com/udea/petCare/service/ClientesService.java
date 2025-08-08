package com.udea.petCare.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.udea.petCare.dto.ClientesDTO;
import com.udea.petCare.dto.ClientesRequestDTO;
import com.udea.petCare.entity.Clientes;
import com.udea.petCare.entity.TipoUsuarios;
import com.udea.petCare.entity.Usuarios;
import com.udea.petCare.mapper.ClientesMapper;
import com.udea.petCare.repository.ClientesRepository;
import com.udea.petCare.repository.TipoUsuariosRepository;
import com.udea.petCare.repository.UsuariosRepository;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TipoUsuariosRepository tipoUsuariosRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<ClientesDTO> findAll() {
        return clientesRepository.findAll().stream()
                .map(ClientesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientesDTO save(ClientesRequestDTO dto) {
        if (usuariosRepository.findByCorreo(dto.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        TipoUsuarios tipoUsuario = tipoUsuariosRepository.findByTipoUsuario("Cliente")
                .orElseThrow(() -> new RuntimeException("Tipo de usuario no encontrado"));

        Clientes cliente = new Clientes();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        cliente.setUsuario(usuariosRepository.save(
                new Usuarios(dto.getCorreo(), passwordEncoder.encode(dto.getClave()), tipoUsuario)));

        clientesRepository.save(cliente);
        return ClientesMapper.toDTO(cliente);
    }
}