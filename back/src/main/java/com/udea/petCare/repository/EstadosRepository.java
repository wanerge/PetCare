package com.udea.petCare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.udea.petCare.entity.Estados;

@Repository
public interface EstadosRepository extends JpaRepository<Estados, Long> {
    Optional<Estados> findByNombreEstado(String nombreEstado);
}
