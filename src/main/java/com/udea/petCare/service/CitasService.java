package com.udea.petCare.service;

import java.util.List;

public interface CitasService {
    List<CitasDTO> findAll();
    CitasDTO save(CitasDTO alumnoDTO);
    CitasDTO update(Integer id, CitasDTO alumnoDTO);
    void delete(Integer id);
}
