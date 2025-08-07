package com.udea.petCare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.udea.petCare.dto.LoginRequestDTO;
import com.udea.petCare.entity.Usuarios;
import com.udea.petCare.repository.UsuariosRepository;
import com.udea.petCare.security.JwtTokenProvider;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String login(LoginRequestDTO dto) {
        Usuarios usuario = usuariosRepository.findByCorreo(dto.getCorreo())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!passwordEncoder.matches(dto.getClave(), usuario.getClaveHash())) {
            throw new RuntimeException("Clave incorrecta");
        }

        String token = jwtTokenProvider.generarToken(usuario.getIdUsuario(), usuario.getTipoUsuario().getTipoUsuario());
        return token;
    }
}
