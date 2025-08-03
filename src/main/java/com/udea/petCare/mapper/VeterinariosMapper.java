package com.udea.petCare.mapper;

import com.udea.petCare.dto.VeterinariosDTO;
import com.udea.petCare.entity.Veterinarios;
import java.util.List;
import java.util.stream.Collectors;

public class VeterinariosMapper {

    public static VeterinariosDTO toDTO(Veterinarios veterinario) {
        VeterinariosDTO dto = new VeterinariosDTO();
        dto.setId(veterinario.getId_veterinario());
        dto.setNombre(veterinario.getNombre());
        dto.setApellido(veterinario.getApellido());
        dto.setTelefono(veterinario.getTelefono());
        dto.setCorreo(veterinario.getUsuario().getCorreo());

        List<String> especialidades = veterinario.getEspecialidadesAsignadas().stream()
                .map(rel -> rel.getEspecialidad().getNombre_especialidad())
                .collect(Collectors.toList());

        dto.setEspecialidades(especialidades);

        return dto;
    }
}
