package com.udea.petCare.mapper;

import com.udea.petCare.dto.VeterinariosRequestDTO;
import com.udea.petCare.entity.*;
import com.udea.petCare.entity.VeterinarioXEspecialidad;
import com.udea.petCare.repository.*;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VeterinarioRequestMapper {

    private final EspecialidadesRepository especialidadesRepo;
    private final UsuariosRepository usuariosRepo;

    public VeterinarioRequestMapper(EspecialidadesRepository especialidadesRepo, UsuariosRepository usuariosRepo) {
        this.especialidadesRepo = especialidadesRepo;
        this.usuariosRepo = usuariosRepo;
    }

    public Veterinarios toEntity(VeterinariosRequestDTO dto) {
        Veterinarios veterinario = new Veterinarios();

        veterinario.setNombre(dto.getNombre());
        veterinario.setApellido(dto.getApellido());
        veterinario.setTelefono(dto.getTelefono());

        // Buscar usuario por correo (opcional: podrías crearlo si no existe)
        Usuarios usuario = usuariosRepo.findByCorreo(dto.getCorreo())
                .orElseGet(() -> {
                    Usuarios nuevoUsuario = new Usuarios();
                    nuevoUsuario.setCorreo(dto.getCorreo());

                    // 🔒 Encriptar la clave antes de guardar
                    // String encrypted = passwordEncoder.encode(dto.getClave());
                    // nuevoUsuario.setClave(encrypted);

                    nuevoUsuario.setClave_hash(null);// (dto.getClave()); // ← en texto plano (¡solo temporal!)
                    return usuariosRepo.save(nuevoUsuario);
                });

        veterinario.setUsuario(usuario);

        // Mapear especialidades
        List<VeterinarioXEspecialidad> especialidadesAsignadas = dto.getEspecialidadesIds().stream()
                .map(id -> {
                    Especialidades esp = especialidadesRepo.findById(id)
                            .orElseThrow(() -> new RuntimeException("Especialidad ID " + id + " no encontrada"));
                    return new VeterinarioXEspecialidad(veterinario, esp);
                })
                .collect(Collectors.toList());

        veterinario.setEspecialidadesAsignadas(especialidadesAsignadas);

        return veterinario;
    }
}
