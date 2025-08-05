package com.udea.petCare.mapper;

import com.udea.petCare.dto.ClientesDTO;
import com.udea.petCare.entity.Clientes;

public class ClientesMapper {

    public static ClientesDTO toDTO(Clientes cliente) {
        if (cliente == null) {
            return null;
        }
        ClientesDTO dto = new ClientesDTO();
        dto.setId(cliente.getIdCliente());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setTelefono(cliente.getTelefono());
        dto.setDireccion(cliente.getDireccion());
        dto.setCorreo(cliente.getUsuario().getCorreo());

        return dto;
    }

}
