package com.udea.petCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.petCare.entity.Especies;

@Repository
public interface EspeciesRepository extends JpaRepository<Especies, Long>{
    
}
