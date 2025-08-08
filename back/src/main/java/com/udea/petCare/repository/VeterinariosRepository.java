package com.udea.petCare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.Veterinarios;

@Repository
public interface VeterinariosRepository extends JpaRepository<Veterinarios, Long> {
    Optional<Veterinarios> findByUsuarioIdUsuario(Long id);
}
