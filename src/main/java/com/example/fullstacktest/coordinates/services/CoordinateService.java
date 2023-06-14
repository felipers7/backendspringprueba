package com.example.fullstacktest.coordinates.services;


import com.example.fullstacktest.coordinates.dto.CoordinateDTO;
import com.example.fullstacktest.coordinates.entities.Coordinate;
import com.example.fullstacktest.coordinates.mapping.CoordinateMapper;
import com.example.fullstacktest.coordinates.repositories.CoordinateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinateService {

    @Autowired
    private CoordinateRepository coordinateRepository;


    public Optional<CoordinateDTO> findOne(String latitud, String longitud){
        //Llamado a repositorio que a la vez convierte de Coordinate a CoordinateDTO
        //con el fin de adaptarlo a la estructura requerida
        return coordinateRepository.findByLatitudAndLongitud(latitud,longitud).map(
                coordinate -> CoordinateMapper.INSTANCE.toCoordinateDTO(coordinate)
        );
    }

    public List<Coordinate> findAll(){
        return coordinateRepository.findAll();
    }
}
