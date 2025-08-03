package com.udea.petCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.CitaXServicio;

@Repository
public interface CitaXServicioRepository extends JpaRepository< CitaXServicio, Long>{

}
