package com.example.fullstacktest.coordinates.repositories;

import com.example.fullstacktest.coordinates.entities.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate,Long> {
    //Query method para solamente aceptar Latitud y Longitud
    Optional<Coordinate> findByLatitudAndLongitud(String latitud, String longitud);
}
