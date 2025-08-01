package com.udea.petCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.TipoUsuarios;

@Repository
public interface GenerosRepository extends JpaRepository<Generos, Long>{

}

