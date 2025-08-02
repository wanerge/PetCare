package com.udea.petCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.Mascotas;

@Repository
public interface MascotasRepository extends JpaRepository<Mascotas, Long>{
    
}

