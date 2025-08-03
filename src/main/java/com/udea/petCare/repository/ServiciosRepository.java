package com.udea.petCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.Servicios;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Long> {

}
