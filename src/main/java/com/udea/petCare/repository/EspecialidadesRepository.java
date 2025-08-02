package com.udea.petCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.Especialidades;

@Repository
public interface EspecialidadesRepository extends JpaRepository<Especialidades, Long>{

}