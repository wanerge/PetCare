package com.udea.petCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.udea.petCare.entity.Usuarios;

@Repository
public interface UsuariosRepository  extends JpaRepository<Usuarios, Long> {
    
}
