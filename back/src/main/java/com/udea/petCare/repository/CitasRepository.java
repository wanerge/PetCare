package com.udea.petCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.Citas;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Long> {
    List<Citas> findByClienteIdCliente(Long clienteId);

    List<Citas> findByClienteIdClienteAndEstadoIdEstado(Long clienteId, Long estadoId);

    List<Citas> findByClienteIdClienteAndEstadoIdEstadoNot(Long clienteId, Long estadoId);

    List<Citas> findByVeterinarioIdVeterinario(Long veterinarioId);

    List<Citas> findByVeterinarioIdVeterinarioAndEstadoIdEstado(Long veterinarioId, Long estadoId);

    List<Citas> findByVeterinarioIdVeterinarioAndEstadoIdEstadoNot(Long veterinarioId, Long estadoId);

}