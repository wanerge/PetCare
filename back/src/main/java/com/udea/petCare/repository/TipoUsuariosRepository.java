package com.udea.petCare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.udea.petCare.entity.TipoUsuarios;

@Repository
public interface TipoUsuariosRepository extends JpaRepository<TipoUsuarios, Long> {
    Optional<TipoUsuarios> findByTipoUsuario(String tipoUsuario);
}
