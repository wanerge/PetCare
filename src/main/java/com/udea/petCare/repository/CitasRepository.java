package com.udea.petCare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.Citas;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Long> {
    List<Citas> findByClienteId(Long clienteId);

    List<Citas> findByMascotaId(Long mascotaId);

    List<Citas> findByVeterinarioId(Long veterinarioId);

    List<Citas> findByEstadoId(Long estadoId);
}